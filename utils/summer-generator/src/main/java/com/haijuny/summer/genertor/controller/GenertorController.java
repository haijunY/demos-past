package com.haijuny.summer.genertor.controller;

import com.haijuny.summer.genertor.service.GeneratorService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class GenertorController {

    @Autowired
    private GeneratorService generatorService;

    @RequestMapping(value = "code", method = RequestMethod.GET)
    public void code(HttpServletRequest request, HttpServletResponse response) throws IOException {
        byte[] data = null;
        String tables = request.getParameter("tables");
        if(StringUtils.isNotBlank(tables)){
            data = generatorService.generatorCode(tables.split(","));
        }

        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"summer-admin-code.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");

        if(data != null){
            response.getOutputStream().write(data);
        }
    }

}
