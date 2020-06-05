package com.haijunyin.layuidemo.permission.module;

import java.util.List;

public class AdminParentMenuInfo {

    private String parentMenuName;

    private List<AdminMenuInfo> adminMenuInfos;

    public AdminParentMenuInfo(){

    }

    public AdminParentMenuInfo(String parentMenuName, List<AdminMenuInfo> adminMenuInfos){
        this.parentMenuName = parentMenuName;
        this.adminMenuInfos = adminMenuInfos;
    }

    public String getParentMenuName() {
        return parentMenuName;
    }

    public void setParentMenuName(String parentMenuName) {
        this.parentMenuName = parentMenuName;
    }

    public List<AdminMenuInfo> getAdminMenuInfos() {
        return adminMenuInfos;
    }

    public void setAdminMenuInfos(List<AdminMenuInfo> adminMenuInfos) {
        this.adminMenuInfos = adminMenuInfos;
    }
}
