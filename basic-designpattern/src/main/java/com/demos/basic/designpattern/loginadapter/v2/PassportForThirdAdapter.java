package com.demos.basic.designpattern.loginadapter.v2;

import com.demos.basic.designpattern.loginadapter.ResultMsg;
import com.demos.basic.designpattern.loginadapter.v1.service.SignInService;
import com.demos.basic.designpattern.loginadapter.v2.adapters.LoginAdapter;
import com.demos.basic.designpattern.loginadapter.v2.adapters.LoginForQQAdapter;
import com.demos.basic.designpattern.loginadapter.v2.adapters.LoginForTokenAdapter;
import com.demos.basic.designpattern.loginadapter.v2.adapters.LoginForWhChatAdapter;

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
