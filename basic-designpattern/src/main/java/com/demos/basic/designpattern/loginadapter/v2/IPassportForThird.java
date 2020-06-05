package com.demos.basic.designpattern.loginadapter.v2;

import com.demos.basic.designpattern.loginadapter.ResultMsg;

public interface IPassportForThird {


    /**
     * QQ登录
     * @param id
     * @return
     */
    ResultMsg loginForQQ(String id);

    /**
     * 微信登录
     * @param id
     * @return
     */
    ResultMsg loginForWhChat(String id);

    /**
     * 记住状态后自动登录
     * @param token
     * @return
     */
    ResultMsg loginForToken(String token);





}
