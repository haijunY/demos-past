package com.yhj.study.mini.springmvc.framework.context;

import com.yhj.study.mini.springmvc.framework.annotation.GPAutowired;
import com.yhj.study.mini.springmvc.framework.annotation.GPController;
import com.yhj.study.mini.springmvc.framework.annotation.GPService;
import com.yhj.study.mini.springmvc.framework.beans.GPBeanFactory;
import com.yhj.study.mini.springmvc.framework.beans.GPBeanWrapper;
import com.yhj.study.mini.springmvc.framework.beans.config.GPBeanDefinition;
import com.yhj.study.mini.springmvc.framework.beans.support.GPBeanDefinitionReader;
import com.yhj.study.mini.springmvc.framework.beans.support.GPDefaultListableBeanFactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * IOC、DI、MVC、AOP
 * @date: 2019/05/28 13:02
 */
public class GPApplicationContext extends GPDefaultListableBeanFactory implements GPBeanFactory {

    private String[] configLocations;

    private GPBeanDefinitionReader reader;

    private List<GPBeanDefinition> beanDefinitions;

    //单例的IOC容器
    private Map<String, Object> singletonObjects = new HashMap<String, Object>();
    //通用的IOC容器
    private Map<String, GPBeanWrapper> factoryBeanInstanceCache = new HashMap<String, GPBeanWrapper>();

    public GPApplicationContext(String... configLocations) {
        this.configLocations = configLocations;
    }

    @Override
    public void refresh(){
        //1、定位配置文件
        reader = new GPBeanDefinitionReader(this.configLocations);
        //2、加载配置文件，扫描相关的类，把它们封装成BeanDefinition
        beanDefinitions = reader.loadBeanDefinitions();
        //3、注册，把配置信息放到容器里面(伪IOC容器)
        doRegisterBeanDefinition(beanDefinitions);
        //4、把不是延迟加载的类，提前初始化
        doAutowrited();

    }

    //只处理非延迟加载的情况
    private void doAutowrited() {
        for(Map.Entry<String, GPBeanDefinition> beanDefinitionEntry : super.beanDefinitionMap.entrySet()){
            String beanName = beanDefinitionEntry.getKey();
            if(!beanDefinitionEntry.getValue().isLazyInit()){
                try {
                    getBean(beanName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void doRegisterBeanDefinition(List<GPBeanDefinition> beanDefinitions) {
        for(GPBeanDefinition beanDefinition : beanDefinitions){
            super.beanDefinitionMap.put(beanDefinition.getFactoryBeanName(), beanDefinition);
        }
    }

    public Object getBean(String beanName) throws Exception {

        //1、初始化
        GPBeanWrapper gpBeanWrapper = instantiateBean(beanName, beanDefinitionMap.get(beanName));

        //2、拿到BeanWrapper之后，把BeanWrapper保存到IOC容器中
//        if(!this.factoryBeanInstanceCache.containsKey(beanName)){
//            throw new Exception("The" + beanName + "is exists!");
//        }
        this.factoryBeanInstanceCache.put(beanName, gpBeanWrapper);

        //3、注入
        populateBean(beanName, new GPBeanDefinition(), gpBeanWrapper);

        return this.factoryBeanInstanceCache.get(beanName).getWrappedInstance();
    }

    private void populateBean(String beanName, GPBeanDefinition gpBeanDefinition, GPBeanWrapper gpBeanWrapper) {
        Object instance = gpBeanWrapper.getWrappedInstance();
        //判断只有加了注解的类，才执行依赖注入
        Class<?>  clazz = gpBeanWrapper.getWrappedClass();
        if(!clazz.isAnnotationPresent(GPController.class) || clazz.isAnnotationPresent(GPService.class)){
            return ;
        }
        //获得所有的fields
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if(!field.isAnnotationPresent(GPAutowired.class)){
                continue;
            }
            GPAutowired autowired = field.getAnnotation(GPAutowired.class);
            String autowiredBeanName = autowired.value().trim();
            if("".equals(autowiredBeanName)){
                autowiredBeanName = field.getType().getName();
            }
            field.setAccessible(true);
            try {
                field.set(instance, this.factoryBeanInstanceCache.get(autowiredBeanName).getWrappedClass());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }

    private GPBeanWrapper instantiateBean(String beanName, GPBeanDefinition gpBeanDefinition) {
        //1、拿到要实例化的对象的类名
        String classname = gpBeanDefinition.getBeanClassName();
        //2、反射实例化，得到一个对象
        Object instance = null;
        try {
            //默认是单例
            if(this.singletonObjects.containsKey(classname)){
                instance = this.singletonObjects.get(classname);
            }else {
                Class<?> clazz = Class.forName(classname);
                instance = clazz.newInstance();
                this.singletonObjects.put(classname, instance);
                this.singletonObjects.put(gpBeanDefinition.getFactoryBeanName(), instance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //3、把这个对象封装到BeanWrapper中
        GPBeanWrapper beanWrapper = new GPBeanWrapper(instance);

        //4、把BeanWrapper存到IOC容器

        return beanWrapper;
    }

    public String[] getBeanDefinionNames(){
        return this.beanDefinitionMap.keySet().toArray(new String[this.beanDefinitionMap.size()]);
    }

    public int getBeanDefinionCount(){
        return this.beanDefinitionMap.size();
    }

    public Properties getConfig(){
        return this.reader.getConfig();
    }

}
