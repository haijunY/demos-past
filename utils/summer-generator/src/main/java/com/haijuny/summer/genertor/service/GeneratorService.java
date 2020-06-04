package com.haijuny.summer.genertor.service;

import com.haijuny.summer.genertor.entity.ColumnEntity;
import com.haijuny.summer.genertor.entity.TableEntity;
import com.haijuny.summer.genertor.mapper.GeneratorMapper;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
public class GeneratorService {

    @Autowired
    private GeneratorMapper generatorMapper;

    public byte[] generatorCode(String[] tableNames){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);

        for(String tableName : tableNames){
            //查询表信息
            Map<String, String> table = generatorMapper.queryTable(tableName);
            //查询列信息
            List<Map<String, String>> columns = generatorMapper.queryColumns(tableName);
            //生成代码
            generatorCode(table, columns, zip);
        }
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }

    private void generatorCode(Map<String, String> table, List<Map<String, String>> columns, ZipOutputStream zip) {

        //配置信息
        Configuration config = getConfig();

        //表信息
        TableEntity tableEntity = new TableEntity();
        tableEntity.setTableName(table.get("tableName"));
        tableEntity.setComments(table.get("tableComment"));
        //表名转换成Java的类名
        String className = tableToJava(tableEntity.getTableName(), config.getString("tablePrefix"));
        tableEntity.setClassName(className);
        tableEntity.setClassname(StringUtils.uncapitalize(className));

        //列信息
        List<ColumnEntity> columnEntityList = new ArrayList<>();
        for(Map<String, String> column : columns){
            ColumnEntity columnEntity = new ColumnEntity();
            columnEntity.setColumnName(column.get("columnName"));
            columnEntity.setDataType(column.get("dataType"));
            columnEntity.setComments(column.get("columnComment"));
            columnEntity.setExtra(column.get("extra"));
            //列名转换成Java属性名
            String attrName = columnToJava(columnEntity.getColumnName());
            columnEntity.setAttrName(attrName);
            columnEntity.setAttrname(StringUtils.uncapitalize(attrName));
            //列的数量，转换成Java类型
            String attrType = config.getString(columnEntity.getDataType(), "unknowType");
            columnEntity.setAttrType(attrType);
            //是否主键
            if("PRI".equalsIgnoreCase(column.get("columnKey")) && tableEntity.getPk() == null){
                tableEntity.setPk(columnEntity);
            }
            columnEntityList.add(columnEntity);
        }
        tableEntity.setColumns(columnEntityList);

        //没主键，则第一个字段为主键
        if(tableEntity.getPk() == null){
            tableEntity.setPk(tableEntity.getColumns().get(0));
        }

        //设置velocity资源加载器
        Properties prop = new Properties();
        prop.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        Velocity.init(prop);

        //封装模板数据
        Map<String, Object> map = new HashMap<>();
        map.put("tableName", tableEntity.getTableName());
        map.put("comments", tableEntity.getComments());
        map.put("pk", tableEntity.getPk());
        map.put("className", tableEntity.getClassName());
        map.put("classname", tableEntity.getClassname());
        map.put("pathName", tableEntity.getClassname().toLowerCase());
        map.put("columns", tableEntity.getColumns());
        map.put("package", config.getString("package"));
        map.put("author", config.getString("author"));
        map.put("email", config.getString("email"));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        map.put("datetime", format.format(new Date()));
        map.put("moduleName", config.getString("mainModule"));
        map.put("secondModuleName", toLowerCaseFirstOne(className));
        VelocityContext context = new VelocityContext(map);

        //获取模板列表
        List<String> templates = getTemplates();
        for(String template : templates){
            //渲染模板
            StringWriter sw = new StringWriter();
            Template tpl = Velocity.getTemplate(template, "UTF-8");
            tpl.merge(context, sw);

            //添加到zip
            try {
                zip.putNextEntry(new ZipEntry(getFileName(template, tableEntity.getClassName(), config.getString("package"), config.getString("mainModule"))));
                org.apache.commons.io.IOUtils.write(sw.toString(), zip, "UTF-8");
                org.apache.commons.io.IOUtils.closeQuietly(sw);
                zip.closeEntry();
            }catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("渲染模板失败， 表名：" + tableEntity.getTableName(), e);
            }

        }



    }

    /** 获取配置信息 */
    public static Configuration getConfig(){
        try{
            return new PropertiesConfiguration("generator.properties");
        }catch (ConfigurationException e){
            throw new RuntimeException("获取配置信息失败", e);
        }
    }

    private List<String> getTemplates() {
        List<String> templates = new ArrayList<>();
        templates.add("template/biz.java.vm");
        templates.add("template/entity.java.vm");
        templates.add("template/mapper.java.vm");
        templates.add("template/mapper.xml.vm");
        return templates;
    }

    /** 表名转换成Java类名 */
    private String tableToJava(String tableName, String tablePrefix) {
        if(StringUtils.isNotBlank(tableName)){
            tableName = tableName.replace(tablePrefix, "");
        }
        return columnToJava(tableName);
    }

    /** 列名转换成Java属性名 */
    private String columnToJava(String columnName) {
        return WordUtils.capitalizeFully(columnName, new char[] { '_' }).replace("_", "");
    }

    //首字母小写
    private Object toLowerCaseFirstOne(String s) {
        if(Character.isLowerCase(s.charAt(0))){
            return s;
        }else {
            return (new StringBuffer()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }


    /** 获取文件名 */
    private String getFileName(String template, String className, String packageName, String mainModule) {
        String packagePath = "main" + File.separator + "java" + File.separator;
        String frontPath = "ui" + File.separator;
        if(StringUtils.isNotBlank(packageName)){
            packagePath += packageName.replace(".", File.separator) + File.separator;
        }

        if(template.contains("biz.java.vm")){
            return packagePath + "biz" + File.separator + className + "Biz.java";
        }

        if(template.contains("mapper.java.vm")){
            return packagePath + "mapper" + File.separator + className + "Mapper.java";
        }

        if(template.contains("entity.java.vm")){
            return packagePath + "entity" + File.separator + className + ".java";
        }

        if(template.contains("controller.java.vm")){
            return packagePath + "controller" + File.separator + className + "Controller.java";
        }

        if(template.contains("mapper.xml.vm")){
            return "main" + File.separator + "resources" + File.separator + "mapper" + File.separator + className + "Mapper.xml";
        }

        return null;
    }



}
