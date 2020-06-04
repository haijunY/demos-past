package com.yhj.study.concurrency.synchronizedvolatile;

/**
 * @date: 2019/05/14 11:33
 */
public class CountOb {

    private Integer i = 0;

    public void add(){
        i++;
    }

    public Integer get(){
        return i;
    }

}
