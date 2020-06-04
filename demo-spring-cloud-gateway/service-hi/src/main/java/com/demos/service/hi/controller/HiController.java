package com.demos.service.hi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yinhaijun
 * @date: 2020/6/4
 */
@RestController
public class HiController {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String hi(String name){
        return "hi:" + name;
    }

}
