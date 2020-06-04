package com.yhj.study.designpattern.loginadapter.v2;

import com.yhj.study.designpattern.adapter.loginadapter.ResultMsg;
import com.yhj.study.designpattern.adapter.loginadapter.v1.service.SignInService;
import com.yhj.study.designpattern.adapter.loginadapter.v2.adapters.LoginAdapter;
import com.yhj.study.designpattern.adapter.loginadapter.v2.adapters.LoginForQQAdapter;
import com.yhj.study.designpattern.adapter.loginadapter.v2.adapters.LoginForTokenAdapter;
import com.yhj.study.designpattern.adapter.loginadapter.v2.adapters.LoginForWhChatAdapter;

public class PassportForThirdAdapter extends SignInService implements IPassportForThird {

    @Override
    public ResultMsg loginForQQ(String id) {
        return processLogin(id, LoginForQQAdapter.class);
    }

    @Override
    public ResultMsg loginForWhChat(String id) {
        return processLogin(id, LoginForWhChatAdapter.class);
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return processLogin(token, LoginForTokenAdapter.class);
    }


    private ResultMsg processLogin(String key, Class<? extends LoginAdapter> clazz) {
        try {
            LoginAdapter adapter = clazz.newInstance();
            if(adapter.support(adapter)){
                return adapter.login(key, adapter);
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}
