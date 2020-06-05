package com.demos.basic.designpattern.loginadapter.v2.adapters;

import com.demos.basic.designpattern.loginadapter.ResultMsg;

public interface LoginAdapter {

    boolean support(Object adapter);

    ResultMsg login(String id, Object adapter);

}
