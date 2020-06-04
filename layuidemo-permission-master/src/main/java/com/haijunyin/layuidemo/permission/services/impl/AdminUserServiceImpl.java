package com.haijunyin.layuidemo.permission.services.impl;

import com.haijunyin.layuidemo.permission.module.AdminMenuInfo;
import com.haijunyin.layuidemo.permission.module.AdminParentMenuInfo;
import com.haijunyin.layuidemo.permission.module.AdminUserInfo;
import com.haijunyin.layuidemo.permission.services.AdminUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Override
    public AdminUserInfo findByUserName(String userName) {
        AdminUserInfo userInfo = new AdminUserInfo();
        userInfo.setId(1);
        userInfo.setUserName("yhj");
        userInfo.setUserPwd("123456");
        List<AdminParentMenuInfo> adminParentMenuInfos = new ArrayList<>();
        //权限管理
        List<AdminMenuInfo> adminMenuInfos1 = new ArrayList<>();
        AdminMenuInfo adminMenuInfo1 = new AdminMenuInfo("filter1","用户","admin/admin_user_list.html");
        adminMenuInfos1.add(adminMenuInfo1);
        AdminMenuInfo adminMenuInfo2 = new AdminMenuInfo("filter2", "角色","admin/admin_role_list.html");
        adminMenuInfos1.add(adminMenuInfo2);
        AdminParentMenuInfo adminParentMenuInfo1 = new AdminParentMenuInfo("权限管理",adminMenuInfos1);
        adminParentMenuInfos.add(adminParentMenuInfo1);
        //订单管理
        List<AdminMenuInfo> adminMenuInfos2 = new ArrayList<>();
        AdminMenuInfo adminMenuInfo11 = new AdminMenuInfo("filter3", "订单列表","order/order_list.html");
        adminMenuInfos2.add(adminMenuInfo11);
        AdminMenuInfo adminMenuInfo22 = new AdminMenuInfo("filter4", "订单推送","order/order_send.html");
        adminMenuInfos2.add(adminMenuInfo22);
        AdminParentMenuInfo adminParentMenuInfo2 = new AdminParentMenuInfo("订单管理",adminMenuInfos2);
        adminParentMenuInfos.add(adminParentMenuInfo2);

        userInfo.setAdminParentMenuInfos(adminParentMenuInfos);
        return userInfo;
    }
}
