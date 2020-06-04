package com.haijunyin.layuidemo.permission.module;

import java.util.List;

public class AdminUserInfo {

    private long id;

    private String userName;

    private String userPwd;

    private List<AdminParentMenuInfo> adminParentMenuInfos;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public List<AdminParentMenuInfo> getAdminParentMenuInfos() {
        return adminParentMenuInfos;
    }

    public void setAdminParentMenuInfos(List<AdminParentMenuInfo> adminParentMenuInfos) {
        this.adminParentMenuInfos = adminParentMenuInfos;
    }
}
