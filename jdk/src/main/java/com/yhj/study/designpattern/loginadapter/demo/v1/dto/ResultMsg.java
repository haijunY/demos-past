package com.yhj.study.designpattern.loginadapter.demo.v1.dto;

public class ResultMsg {
    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ResultMsg{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
