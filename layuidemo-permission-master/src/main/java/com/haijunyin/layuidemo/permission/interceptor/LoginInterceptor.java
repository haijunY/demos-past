package com.haijunyin.layuidemo.permission.interceptor;

import com.haijunyin.layuidemo.permission.module.AdminUserInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
public class LoginInterceptor extends HandlerInterceptorAdapter{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        AdminUserInfo adminUserInfo = (AdminUserInfo) session.getAttribute("adminUserInfo");
        //未登录去登录
        if(null == adminUserInfo){
            //注意：这里需要写上"/login"，而不是"login"，否则重定向的地址只会替换最后一个"/"后面的字符串
            response.sendRedirect("/login");
        }
        return true;
    }

}
