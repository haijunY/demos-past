package com.demos.basic.designpattern.delegateandstrategy.handler;

import java.util.Map;

/**
 * @date: 2019/05/24 15:32
 */
public abstract class AbstractSmsHandler {

    String phoneNo;
    String realName;
    String userName;

    void parseParms(Map<String, String> parms){
        phoneNo = parms.get("phoneNo");
        realName = parms.get("realName");
        userName = parms.get("userName");
    }

    public abstract void sendSms(Map<String, String> parms);


}
