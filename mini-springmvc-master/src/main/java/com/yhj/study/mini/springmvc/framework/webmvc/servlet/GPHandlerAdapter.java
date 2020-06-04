package com.yhj.study.mini.springmvc.framework.webmvc.servlet;

import com.yhj.study.mini.springmvc.framework.annotation.GPRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @date: 2019/05/30 14:13
 */
public class GPHandlerAdapter {

    public boolean supports(Object hanlder){
     return hanlder instanceof GPHandlerMapping;
    }

    public GPModelAndView handler(HttpServletRequest request, HttpServletResponse response, Object handler) throws InvocationTargetException, IllegalAccessException {
        GPHandlerMapping handlerMapping = (GPHandlerMapping) handler;
        //把方法的形参列表和request的参数列表所在的顺序进行一一对应
        Map<String, Integer> paramIndexMapping = new HashMap<String ,Integer>();
        //提取方法中加了注解的参数
        //把方法上的注解拿到，得到的是一个二维数组
        //因为一个参数可以有多个注解，而一个方法又有多个参数
        Annotation[] [] pa = handlerMapping.getMethod().getParameterAnnotations();
        for(int i = 0;i<pa.length;i++){
            for(Annotation a : pa[i]){
                if(a instanceof GPRequestParam){
                    String paramName = ((GPRequestParam) a).value();
                    if(!"".equals(paramName.trim())){
                        paramIndexMapping.put(paramName, i);
                    }
                }
            }
        }

        //提取方法中的request和response参数
        Class<?> [] paramsTypes = handlerMapping.getMethod().getParameterTypes();
        for(int i = 0; i < paramsTypes.length; i++){
            Class<?> type = paramsTypes[i];
            if(type == HttpServletRequest.class ||
                    type == HttpServletResponse.class){
                paramIndexMapping.put(type.getName(),i);
            }
        }

        //活动方法的形参列表
        Map<String, String[]> params = request.getParameterMap();
        //实参列表
        Object[] paramValues = new Object[paramsTypes.length];
        for(Map.Entry<String, String[]> parm : params.entrySet()){
            String value = Arrays.toString(parm.getValue()).replaceAll("\\[|\\]","")
                    .replaceAll("\\s",",");
            if(!paramIndexMapping.containsKey(parm.getKey())){
                continue;
            }
            int index = paramIndexMapping.get(parm.getKey());
            paramValues[index] = caseStringValue(value, paramsTypes[index]);
        }

        if(paramIndexMapping.containsKey(HttpServletRequest.class.getName())){
            int reqIndex = paramIndexMapping.get(HttpServletResponse.class.getName());
            paramValues[reqIndex] = request;
        }

        if(paramIndexMapping.containsKey(HttpServletResponse.class.getName())){
            int respIndex = paramIndexMapping.get(HttpServletResponse.class.getName());
            paramValues[respIndex] = response;
        }

        Object result = handlerMapping.getMethod().invoke(handlerMapping.getController(),paramValues);

        if(result == null || result instanceof Void){
            return null;
        }

        boolean isModelAndView = handlerMapping.getMethod().getReturnType() == GPModelAndView.class;
        if(isModelAndView){
            return (GPModelAndView) result;
        }


        return null;
    }

    private Object caseStringValue(String value, Class<?> paramsType) {
        //如果是int
        if(String.class == paramsType){
            return value;
        }
        else if(Integer.class == paramsType){
            return Integer.valueOf(value);
        }
        else if(Double.class == paramsType){
            return Double.valueOf(value);
        }else {
            if(value != null){
                return value;
            }
            return null;
        }
        //如果还有double或者其他类型加if
        //可以考虑使用策略模式哦

    }

}
