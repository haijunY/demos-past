package com.yhj.study.designpattern.loginadapter.v2.adapters;

import com.yhj.study.designpattern.adapter.loginadapter.ResultMsg;

public interface LoginAdapter {

    boolean support(Object adapter);

    ResultMsg login(String id, Object adapter);

}
