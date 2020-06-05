package com.demos.basic.designpattern.loginadapter.v2.adapters;

import com.demos.basic.designpattern.loginadapter.ResultMsg;

public class LoginForQQAdapter implements LoginAdapter {
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForQQAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        return null;
    }
}
