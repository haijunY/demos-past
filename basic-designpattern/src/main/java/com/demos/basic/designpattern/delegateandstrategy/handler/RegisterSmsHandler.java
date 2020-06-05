package com.demos.basic.designpattern.delegateandstrategy.handler;

import java.util.Map;

/**
 * @date: 2019/05/24 15:23
 */
public class RegisterSmsHandler extends AbstractSmsHandler {

    @Override
    public void sendSms(Map<String, String> parms){
        parseParms(parms);
        System.out.println("正在发送给: " + phoneNo + " 的用户！内容：" + getContent(realName, userName));
    }

    private String getContent(String realName, String userName) {
        return "恭喜" + realName + "注册成功,用户名为：" + userName;
    }
}
