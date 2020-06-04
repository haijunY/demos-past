package com.yhj.study.designpattern.delegateandstrategy.handler;

import java.util.Map;

/**
 * @date: 2019/05/24 15:30
 */
public class LoginInSmsHandler extends AbstractSmsHandler{


    @Override
    public void sendSms(Map<String, String> parms){
        parseParms(parms);
        System.out.println("正在发送给: " + phoneNo + " 的用户！内容：" + getContent(userName));
    }

    private String getContent(String userName) {
        return "您已登录成功！用户名：" + userName;
    }

}
