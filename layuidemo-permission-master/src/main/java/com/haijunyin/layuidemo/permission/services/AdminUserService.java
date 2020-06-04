package com.haijunyin.layuidemo.permission.services;


import com.haijunyin.layuidemo.permission.module.AdminUserInfo;

public interface AdminUserService {

    AdminUserInfo findByUserName(String userName);

}
