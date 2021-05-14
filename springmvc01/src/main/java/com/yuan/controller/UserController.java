package com.yuan.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuan.pojo.User;
import com.yuan.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@SuppressWarnings()
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/j1")//produces标签用于处理json乱码,produces = "application/json;charset=utf-8"
    @ResponseBody//不走试图解析或者直接在类上面加上RestController标签
    public String json1() throws JsonProcessingException {
        User user=new User(1,"秦将","man");
        //将user对象转换json
//        ObjectMapper objectMapper=new ObjectMapper();
//        String str= null;
//
//        str = objectMapper.writeValueAsString(user);

        return JsonUtils.getJson(user,"yy-mm-dd");
    }

    @RequestMapping("/j2")
    @ResponseBody
    public String fastJsonTest(){
        List<User> userList=new ArrayList<User>();
        User user1=new User(1,"秦将","man");
        User user2=new User(2,"秦将","man");
        User user3=new User(3,"秦将","man");
        User user4=new User(3,"秦将","man");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        System.out.println("java对象转json字符串");
        String t1= JSON.toJSONString(userList);
        String t2=JSON.toJSONString(user1);
        System.out.println(t1);
        System.out.println("json字符串转Java对象");
        User json_user=JSON.parseObject(t2,User.class);
        System.out.println(json_user);
        System.out.println("Java对象转json对象");
        JSONObject jsonObject1= (JSONObject) JSON.toJSON(user2);
        System.out.println(jsonObject1);

        System.out.println("json对象转java对象");
        User user_json=JSON.toJavaObject(jsonObject1,User.class);
        System.out.println(user_json);
        return "你好";





    }



    @RequestMapping("/t1")
    public String test1(String name, Model model){
       //1.接受前端参数 localhost:8080/user/t1？name=
        System.out.println("接收到的前端数据为："+name);
        //2.将结果返回前端
        model.addAttribute("msg",name);
        return "hello";


    }

    @RequestMapping("t2")
    public String test2(@RequestParam("username") String name, Model model){
        //RequestParam可以将前端数据username接收到name
        model.addAttribute("msg",name);
        return "hello";

    }

    @RequestMapping("/t3")
    public String test3(User user,Model model){
        //前端接收对象,  localhost:8080/user/t3?id=1&name=Yuan&age=24
        System.out.println(user);
        model.addAttribute("msg",user);
        return "hello";
    }
    @RequestMapping("/t4")//ModelMap继承了Model,LinkedHashMap
    public String test4(ModelMap modelMap){

        modelMap.addAttribute("msg","hello modelMap");
        return "hello";
    }
}
