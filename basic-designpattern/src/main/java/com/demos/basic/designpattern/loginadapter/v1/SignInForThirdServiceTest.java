package com.demos.basic.designpattern.loginadapter.v1;

//import com.demos.basic.designpattern.adapter.loginadapter.v1.service.SignInForThirdService;

import com.demos.basic.designpattern.loginadapter.v1.service.SignInForThirdService;

public class SignInForThirdServiceTest {

    public static void main(String[] args) {
        SignInForThirdService signInForThirdService = new SignInForThirdService();
        signInForThirdService.login("username", "123456");
        signInForThirdService.loginForQQ("openId");
        signInForThirdService.loginForWeChart("openId");
    }

}
