package com.yhj.study.spring.mvcframework.v2;

import com.yhj.study.spring.mvcframework.annotation.GPAutowired;
import com.yhj.study.spring.mvcframework.annotation.GPController;
import com.yhj.study.spring.mvcframework.annotation.GPRequestMapping;
import com.yhj.study.spring.mvcframework.annotation.GPService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

/**
 * @date: 2019/05/18 11:15
 */
public class GPDispatcherServlet extends HttpServlet {

    //保存application.properties
    private Properties contextConfig = new Properties();

    //保存扫描到的所有的类名
    private List<String> classNames = new ArrayList<String>();

    //IOC容器
    private Map<String, Object> ioc = new HashMap<String, Object>();

    //保存url和method的对应关系
    private Map<String, Method> handlerMapping = new HashMap<String, Method>();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    //运行阶段
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //6.调用，运行阶段
        try {
            doDispatch(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("500 Exception,Detail:" + Arrays.toString(e.getStackTrace()));
        }


    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp)throws Exception {
        //绝对路径
        String url = req.getRequestURI();
        //处理相对路径
        String contextPath = req.getContextPath();
        url = url.replaceAll(contextPath, "").replaceAll("/+", "/");
        if(!this.handlerMapping.containsKey(url)){
            resp.getWriter().write("404 Not Found!!!");
            return;
        }
        Method method = this.handlerMapping.get(url);

        String beanName = toLowerFirstCase(method.getDeclaringClass().getSimpleName());
        Map<String, String[]> parameterMap = req.getParameterMap();
        method.invoke(ioc.get(beanName), new Object[]{parameterMap.get("name")[0], resp});



    }

    //初始化阶段
    @Override
    public void init(ServletConfig config) throws ServletException {

        //1.加载配置文件
        doLoadConfig(config.getInitParameter("contextConfigLocation"));

        //2.扫描相关的类
        doScanner(contextConfig.getProperty("scanPackage"));

        //3.初始化相关的类，并且将他们放入到IOC容器中
        doInstance();

        //4.完成依赖注入
        doAutowired();

        //5.初始化HandlerMapping
        initHandlerMapping();

    }


    private void doLoadConfig(String contextConfigLocation){
        //直接从类路径下找到Spring主配置文件路径
        //并且将其读取出来放到properties对象中
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(contextConfigLocation);
        try {
            contextConfig.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void doScanner(String scanPackage) {
        //scanPackage = com.yhj.diy 存储的是包路径
        //转换成文件路径
        URL url = this.getClass().getClassLoader().getResource("/" + scanPackage.replace(".","/"));
        File classpath = new File(url.getFile().replaceAll("%20", " "));//解决路径中空格问题
        for(File file : classpath.listFiles()){
            if(file.isDirectory()){
                doScanner(scanPackage + "." + file.getName());
            }else {
                if(!file.getName().endsWith(".class")){continue;}
                String className = scanPackage + "." + file.getName().replace(".class","");
                classNames.add(className);
            }
        }

    }

    private void doInstance() {
        //初始化，为DI做准备
        if(classNames.isEmpty()){
            return;
        }
        try {
            for(String className : classNames){
                Class<?> clazz = Class.forName(className);

                //只需要初始化加了注解的类
                if(clazz.isAnnotationPresent(GPController.class)){
                    Object instance = clazz.newInstance();
                    //spring默认类名首字母小写
                    String beanName = toLowerFirstCase(clazz.getSimpleName());
                    ioc.put(beanName, instance);
                }else if(clazz.isAnnotationPresent(GPService.class)) {
                    //1.默认类名首字母小写
                    String beanName = toLowerFirstCase(clazz.getSimpleName());
                    //2.自定义的beanName
                    GPService service= clazz.getAnnotation(GPService.class);
                    if(!"".equals(service.value())){
                        beanName = service.value();
                    }
                    ioc.put(beanName, clazz.newInstance());


                    //3.根据类型自动赋值
                    for(Class<?> i : clazz.getInterfaces()){
                        if(ioc.containsKey(i.getName())){
                            throw new Exception("The " + i.getName() + " is exist");
                        }
                        ioc.put(i.getName(),  clazz.newInstance());
                    }

                }else{
                    continue;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private String toLowerFirstCase(String simpleName){
        char[] chars = simpleName.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }


    private void doAutowired() {

        if(ioc.isEmpty()){
            return;
        }

        for(Map.Entry<String,Object> entry : ioc.entrySet()){
            Field[] fields = entry.getValue().getClass().getDeclaredFields();
            for(Field field : fields){
                if(!field.isAnnotationPresent(GPAutowired.class)){continue;}
                GPAutowired autowired = field.getAnnotation(GPAutowired.class);

                //如果用户没自定义bean，默认就根据类型注入
                String beanName = autowired.value().trim();
                if("".equals(beanName)){
                    beanName = field.getType().getName();
                }

                //
                field.setAccessible(true);

                try {
                    //用反射机制动态给字段赋值
                    field.set(entry.getValue(), ioc.get(beanName));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }


        }

    }

    private void initHandlerMapping(){
        if(ioc.isEmpty()){
            return;
        }

        for(Map.Entry<String, Object> entry : ioc.entrySet()){
            Class<?> clazz = entry.getValue().getClass();
            if(!clazz.isAnnotationPresent(GPController.class)){continue;}

            //保存写在类上面的url
            String baseUrl = "";
            if(clazz.isAnnotationPresent(GPRequestMapping.class)){
                GPRequestMapping requestMapping = clazz.getAnnotation(GPRequestMapping.class);
                baseUrl = requestMapping.value();
            }

            //默认获取所有public方法
            for(Method method : clazz.getMethods()){
                if(!method.isAnnotationPresent(GPRequestMapping.class)){continue;}

                GPRequestMapping requestMapping = method.getAnnotation(GPRequestMapping.class);

                //多个/相连，替换成一个/
                String url = ("/" + baseUrl + "/" +requestMapping.value()).replaceAll("/+", "/");
                handlerMapping.put(url, method);


            }

        }
    }

}
