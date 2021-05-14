package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {

    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password, Model model){
        //把用户信息存储在session中
        System.out.println("username:"+username);
        session.setAttribute("userLoginInfo",username);
        model.addAttribute("username",username);
        model.addAttribute("password",password);
        return "main";
    }

    @RequestMapping("/goOut")
    public String goOut(HttpSession session){
        session.invalidate();
        return "login";
    }

    @RequestMapping("/goLogin")
    public String login(){
        //把用户信息存储在session中
        return "login";
    }

    @RequestMapping("/main")
    public String test(){
        return "main";
    }
}
