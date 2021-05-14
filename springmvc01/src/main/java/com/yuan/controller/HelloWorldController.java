package com.yuan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RequestMapping("/hello")//在类作用上，需要先凭借这个路径，再拼接方法名上的路径
//@RestController//将这个类里面的方法直接返回数据
public class HelloWorldController  {


    //封装数据
    @RequestMapping("/test")//处理路径为hello的请求
    public String hello(Model model){
        model.addAttribute("msg","你好世界");
      return "admin/hello";//返回的字符串就是视图名字
    }

    //过滤器解决乱码,用Get方法不会产生乱码，post方法会产生乱码
    @RequestMapping("/form/t1")
    public String test(String name,Model model){
        System.out.println(name);
        model.addAttribute("msg",name);
        return "hello";
    }

}
