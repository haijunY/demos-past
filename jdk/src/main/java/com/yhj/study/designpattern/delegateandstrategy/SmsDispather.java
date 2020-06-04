package com.yhj.study.designpattern.delegateandstrategy;

import com.yhj.study.designpattern.delegateandstrategy.handler.AbstractSmsHandler;
import com.yhj.study.designpattern.delegateandstrategy.handler.LoginInSmsHandler;
import com.yhj.study.designpattern.delegateandstrategy.handler.RegisterSmsHandler;
import com.yhj.study.designpattern.delegateandstrategy.handler.SmsTypeEnums;

import java.util.HashMap;
import java.util.Map;

/**
 * @date: 2019/05/24 15:26
 */
public class SmsDispather {

    private static Map<SmsTypeEnums, AbstractSmsHandler> dispatherMap = new HashMap<>();

    private static Map<String, String> parms = new HashMap<>();

    static {
        parms.put("phoneNo","13511111111");
        parms.put("realName", "张三");
        parms.put("userName", "zs");
    }

    static {
        dispatherMap.put(SmsTypeEnums.REGISTER_SMS, new RegisterSmsHandler());
        dispatherMap.put(SmsTypeEnums.LOGIN_IN_SMS, new LoginInSmsHandler());
    }

    public static void main(String[] args) {
        //发送注册短信
        AbstractSmsHandler register = dispatherMap.get(SmsTypeEnums.REGISTER_SMS);
        register.sendSms(parms);
        //发送登录短信
        AbstractSmsHandler loginIn = dispatherMap.get(SmsTypeEnums.LOGIN_IN_SMS);
        loginIn.sendSms(parms);
    }


}
