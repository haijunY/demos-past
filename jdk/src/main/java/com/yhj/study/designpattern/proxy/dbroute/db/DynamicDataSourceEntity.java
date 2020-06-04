package com.yhj.study.designpattern.proxy.dbroute.db;

/**
 * Created by yhj on @date: 2019/05/08
 */
public class DynamicDataSourceEntity {

    public final static String DEFAULT_SOURCE = null;

    private static final ThreadLocal<String> local = new ThreadLocal<>();

    private DynamicDataSourceEntity(){

    }

    public static String get(){
        return local.get();
    }

    public static void restore(){
        local.set(DEFAULT_SOURCE);
    }

    //DB_2018
    //DB_2019
    public static void set(String source){
        local.set(source);
    }

    public static void set(int year){
        local.set("DB_" + year);
    }
}
