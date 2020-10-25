package com.cjt.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    /**
     * 用户登录
     */
    @PostMapping("/login")
    public String login(String userName, String uId, Model model){
        Subject subject = SecurityUtils.getSubject();
        //将学号作为登录密码
        UsernamePasswordToken token = new UsernamePasswordToken(userName,uId);
        try{
            subject.login(token);
            //若登录成功，则将用户存入session
            Session session = subject.getSession();
            //用学号作为唯一标志
            session.setAttribute("loginUser",uId);
            return "function";
        }catch (UnknownAccountException e){
            model.addAttribute("condition","姓名有误或未报名");
            return "login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("condition","学号有误");
            return "login";
        }
    }

    /**
     * 用户注销
     */
    @GetMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        Session session = subject.getSession();
        return "function";
    }

}
