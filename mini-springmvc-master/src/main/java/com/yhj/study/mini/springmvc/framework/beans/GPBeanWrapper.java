package com.yhj.study.mini.springmvc.framework.beans;

/**
 * @date: 2019/05/28 16:37
 */
public class GPBeanWrapper {

    private Object instance;

    public GPBeanWrapper(Object instance) {
        this.instance = instance;
    }

    /**
     * Return the bean instance wrapped by this object.
     */
    public Object getWrappedInstance(){
        return instance;
    }

    /**
     * Return the type of the wrapped bean instance.
     */
    public Class<?> getWrappedClass(){
        return instance.getClass();
    }

}
