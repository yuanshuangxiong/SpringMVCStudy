package com.yuan.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv=new ModelAndView();
        mv.addObject("msg","HelloSpringMVC");//模型装数据
        mv.setViewName("hello");//要跳转的页面 /WEB-IFNF/jsp/hello.jsp
        return mv;
    }
}
