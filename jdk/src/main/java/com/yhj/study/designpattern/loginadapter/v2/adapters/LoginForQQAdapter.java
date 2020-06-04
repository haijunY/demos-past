package com.yhj.study.designpattern.loginadapter.v2.adapters;

import com.yhj.study.designpattern.adapter.loginadapter.ResultMsg;

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
