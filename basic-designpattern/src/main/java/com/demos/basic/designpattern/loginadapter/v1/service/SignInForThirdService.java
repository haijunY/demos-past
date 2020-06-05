package com.demos.basic.designpattern.loginadapter.v1.service;

import com.demos.basic.designpattern.loginadapter.ResultMsg;

public class SignInForThirdService extends SignInService {

    public ResultMsg loginForQQ(String openId){
        //

        return loginForRegist(openId, null);
    }


    public ResultMsg loginForWeChart(String openId){
        return null;
    }




    public ResultMsg loginForRegist(String username, String password){
        super.regist(username, null);
        return super.login(username, null);
    }

}
