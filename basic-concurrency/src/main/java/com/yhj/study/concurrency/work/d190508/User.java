package com.yhj.study.concurrency.work.d190508;

import java.io.Serializable;

/**
 * @date: 2019/05/10 11:06
 */
public class User implements Serializable{

    private long userId;

    private String userName;

    public User(){

    }

    public User(long userId, String userName){
        this.userId = userId;
        this.userName = userName;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
