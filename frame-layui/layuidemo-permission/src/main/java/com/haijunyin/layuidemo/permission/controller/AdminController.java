package com.haijunyin.layuidemo.permission.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "admin")
public class AdminController {

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(){
        return "权限List测试";
    }

}
