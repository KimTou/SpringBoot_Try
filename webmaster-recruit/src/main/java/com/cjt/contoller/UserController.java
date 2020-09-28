package com.cjt.contoller;

import com.cjt.domain.User;

import com.cjt.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cjt
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserMapper userMapper;

    /**
     * 用户报名
     */
    @PostMapping("/register")
    public String register(User user, Model model){
        if(user.getUserName()==null||user.getuId()==null||user.getMajor()==null||user.getResume()==null){
            model.addAttribute("condition","请填写有效信息");
            //重定向回当前页面
            return "redirect:/register";
        }
        //通过学号来查询是否已报名
        if(userMapper.findUser(user.getuId())!=null){
            System.out.println(user);
            model.addAttribute("condition","你已报名过");
        }
        else{
            userMapper.insertUser(user);
            //获取主键值需通过访问对象获取，而不是通过函数返回值获取
            System.out.println(user.getId());
            model.addAttribute("condition","报名成功");
        }
        return "success";
    }
}
