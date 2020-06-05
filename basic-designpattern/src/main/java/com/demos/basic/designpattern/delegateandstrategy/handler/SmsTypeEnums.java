package com.demos.basic.designpattern.delegateandstrategy.handler;

public enum SmsTypeEnums {

    REGISTER_SMS("1", "注册短信"),
    LOGIN_IN_SMS("2", "登录短信")
    ;

    private String code;

    private String message;

    SmsTypeEnums(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
