package config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //金登录页面放行
        if(request.getRequestURI().contains("goLogin"))return true;
        if(request.getRequestURI().contains("login")) return true;
        //判断是否登录,第一次登陆没有session
        HttpSession session=request.getSession();
        if(session.getAttribute("userLoginInfo")!=null){
            return true;
        }
        //如果没有登陆，直接转到登录界面
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }
}
