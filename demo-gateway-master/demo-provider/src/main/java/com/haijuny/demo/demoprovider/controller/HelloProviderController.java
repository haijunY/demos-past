package com.haijuny.demo.demoprovider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloProviderController {

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello(){
        return "helloProvider---";
    }

}
