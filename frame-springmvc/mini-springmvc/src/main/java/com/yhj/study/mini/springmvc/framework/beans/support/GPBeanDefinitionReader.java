package com.yhj.study.mini.springmvc.framework.beans.support;

import com.yhj.study.mini.springmvc.framework.beans.config.GPBeanDefinition;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @date: 2019/05/28 14:39
 */
public class GPBeanDefinitionReader {

    private List<String> registyBeanClasses = new ArrayList<String>();

    private Properties config = new Properties();

    //固定配置文件的key，类似XML的规范
    private final String SCAN_PACKAEE = "scanPackage";

    public GPBeanDefinitionReader(String... locations) {
        //通过URL定位找到其所对应的文件，然后转换为文件流
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(locations[0].replace("classpath:", ""));
        try {
            config.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null != is){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        doScanner(config.getProperty(SCAN_PACKAEE));
    }

    private void doScanner(String scanPackage) {
        //scanPackage = com.yhj 存储的是包路径
        //转换成文件路径
        URL url = this.getClass().getResource("/" + scanPackage.replace(".","/"));
        File classpath = new File(url.getFile().replaceAll("%20", " "));//解决路径中空格问题
        for(File file : classpath.listFiles()){
            if(file.isDirectory()){
                doScanner(scanPackage + "." + file.getName());
            }else {
                if(!file.getName().endsWith(".class")){continue;}
                String className = scanPackage + "." + file.getName().replace(".class","");
                registyBeanClasses.add(className);
            }
        }
    }

    public Properties getConfig(){
        return this.config;
    }

    //把每一个配置信息解析成GPBeanDefinition对象
    public List<GPBeanDefinition> loadBeanDefinitions(){
        List<GPBeanDefinition> list = new ArrayList<GPBeanDefinition>();
        for (String className : registyBeanClasses) {
            GPBeanDefinition beanDefinition = doCreateBeanDefinition(className);
            if (null != beanDefinition){
                list.add(beanDefinition);
            }
        }
        return list;
    }

    private GPBeanDefinition doCreateBeanDefinition(String className){
        try {
            Class<?> beanClass = Class.forName(className);
            //有可能是一个接口，用它的实现类作为beanClassName
            if(!beanClass.isInterface()){
                GPBeanDefinition beanDefinition = new GPBeanDefinition();
                beanDefinition.setBeanClassName(className);
                beanDefinition.setFactoryBeanName(beanClass.getSimpleName());
                return beanDefinition;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private String toLowerFirstCase(String simpleName){
        char[] chars = simpleName.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }
}
