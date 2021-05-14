package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pojo.User;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//import java.net.http.HttpResponse;

@RestController
public class AjaxController {

    @RequestMapping("/t1")
    public String test(){
        return "hello";
    }

    @RequestMapping("/a1")
    public void a1(String name, HttpServletResponse response) throws IOException {
        System.out.println("a1:param=》"+name);
        if("yuan".equals(name)){
            response.getWriter().println("true");
        }else{
            response.getWriter().println("false");
        }
    }

    @RequestMapping("/a2")
    public List<User> a2(){
        System.out.println("进入了a2方法");
        List<User>userList=new ArrayList<User>();
        userList.add(new User(1,"kuanshen","man"));
        userList.add(new User(2,"yuan","man"));
        return userList;
    }

    @RequestMapping("/a3")
    public String a3(String name,String pwd){
        System.out.println(name+"  ====  "+pwd);
        String msg="";
        if(name!=null){
            if("admin".equals(name)){
                msg="ok";
            }else{
                msg="用户名有误";
            }
        }
        if(pwd!=null){
            if("123456".equals(pwd)){
                msg="ok";
            }else{
                msg="密码有误";
            }
        }
        System.out.println("msg:"+msg);
        return msg;
    }

}
