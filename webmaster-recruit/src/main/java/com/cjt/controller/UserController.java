package com.cjt.controller;

import com.cjt.pojo.User;

import com.cjt.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cjt
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户报名
     */
    @PostMapping("/register")
    public String register(User user, Model model) {
        if (user.getUserName() == null || user.getUId() == null || user.getMajor() == null || user.getResume() == null) {
            model.addAttribute("condition", "请填写有效信息");
            //重定向回当前页面
            return "redirect:/register";
        }
        //通过学号来查询是否已报名
        if (userService.findUser(user.getUId()) != null) {
            System.out.println(user);
            model.addAttribute("condition", "你已报名过");
        } else {
            userService.insertUser(user);
            //获取主键值需通过访问对象获取，而不是通过函数返回值获取
            System.out.println(user.getId());
            model.addAttribute("condition", "报名成功");
        }
        return "result";
    }

    @PostMapping("/result")
    public String result(String userName, String uId){
        Subject subject = SecurityUtils.getSubject();
        //将学号作为登录密码
        UsernamePasswordToken token = new UsernamePasswordToken(userName,uId);

        subject.login(token);
        return "result";
    }
}
