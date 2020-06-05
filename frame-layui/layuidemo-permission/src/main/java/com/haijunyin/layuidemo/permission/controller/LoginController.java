package com.haijunyin.layuidemo.permission.controller;

import com.haijunyin.layuidemo.permission.module.AdminUserInfo;
import com.haijunyin.layuidemo.permission.services.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private AdminUserService adminUserService;

    /**
     * 设置默认打开地址http://localhost:8020的跳转(需要在拦截器中排除)
     * 1.已登录，跳转到index.html，把adminUserInfo返回前端渲染
     * 2.未登录，跳转到登录页
     */
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(HttpServletRequest request, ModelMap modelMap){
        HttpSession session = request.getSession();
        AdminUserInfo adminUserInfo = (AdminUserInfo) session.getAttribute("adminUserInfo");
        if(null != adminUserInfo){
            modelMap.addAttribute("adminUserInfo",adminUserInfo);
            return "index";
        }else{
            return "login";
        }
    }

    /**
     * 登录(需要在拦截器中排除)
     * 1.已登录，跳转到index.html，把adminUserInfo返回前端渲染
     * 2.未登录，验证密码，如果密码正确，跳转到index.html, 则把用户信息放入session，并把adminUserInfo返回前端渲染
     *                     如果密码错误，跳转到login.html
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(@RequestParam(value = "userName", required = false) String userName,
                        @RequestParam(value = "userPwd", required = false) String userPwd,
                        @RequestParam(value = "verifyCode", required = false) String verifyCode,
                        HttpServletRequest request,
                        ModelMap modelMap){

        //先验证session，再验证密码
        HttpSession session = request.getSession();
        AdminUserInfo adminUserInfo = (AdminUserInfo) session.getAttribute("adminUserInfo");
        if(null != adminUserInfo){
            modelMap.addAttribute("adminUserInfo",adminUserInfo);
            return "index";
        }else{
            //验证密码
            AdminUserInfo adminUserInfo0 = adminUserService.findByUserName(userName);
            System.out.println("验证登录...userName="+userName+"userPwd="+userPwd+"verifyCode="+verifyCode);
            if(adminUserInfo0.getUserPwd().equals(userPwd)){
                //用户信息放入session
                System.out.println("登录...成功..." + "用户名：" + userName);
                request.getSession().setAttribute("adminUserInfo", adminUserInfo0);
                modelMap.addAttribute("adminUserInfo",adminUserInfo0);
                return "index";
            }else{
                System.out.println("登录...密码输入错误..." + "用户名：" + userName);
                return "login";
            }
        }
    }

}
