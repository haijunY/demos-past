package com.yhj.study.mini.springmvc.framework.webmvc.servlet;

import java.util.Map;

/**
 * @date: 2019/05/30 14:18
 */
public class GPModelAndView {

    private String viewName;
    private Map<String, ?> model;

    public GPModelAndView(String viewName) {
        this.viewName = viewName;
    }

    public GPModelAndView(String viewName, Map<String, ?> model) {
        this.viewName = viewName;
        this.model = model;
    }

    public String getViewName() {
        return viewName;
    }

    public Map<String, ?> getModel() {
        return model;
    }
}
