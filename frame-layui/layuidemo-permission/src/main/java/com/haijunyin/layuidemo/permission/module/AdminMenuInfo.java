package com.haijunyin.layuidemo.permission.module;

public class AdminMenuInfo {

    /** 子菜单唯一ID，在页面上面会以它做唯一区分的，对应到相应子窗口的lay-id属性 */
    private String filterId;

    /** 子菜单名，对应子窗口的title */
    private String menuName;

    /** 子菜单URL，对应子窗口的链接html，点击子菜单后，会打开一个iframe并链接到此url */
    private String menuUrl;

    public AdminMenuInfo(){

    }

    public AdminMenuInfo(String filterId, String menuName, String menuUrl){
        this.filterId = filterId;
        this.menuName = menuName;
        this.menuUrl = menuUrl;
    }

    public String getFilterId() {
        return filterId;
    }

    public void setFilterId(String filterId) {
        this.filterId = filterId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }
}
