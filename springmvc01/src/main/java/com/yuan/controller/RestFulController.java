package com.yuan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestFulController {

    //这两个标签相等
//    @RequestMapping(path="/add/{a}/{b}",method = RequestMethod.GET)//@patnvaiable能够将路径变量映射到a,b里面
    @GetMapping("/add/{a}/{b}")
    public String test1(@PathVariable int a, @PathVariable  int b, Model model){
        int res=a+b;

        model.addAttribute("msg","结果为："+res);
        return "/hello";
    }

    @RequestMapping("/yuan")
    public String test2(Model model){
        model.addAttribute("msg","hello");
        return "redirect:/index.jsp";
    }
}
