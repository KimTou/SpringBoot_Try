package com.cjt.controller;

import com.cjt.pojo.User;

import com.cjt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        //检查数据是否为空
        if (user.getUserName() == null || user.getUId() == null || user.getMajor() == null || user.getResume() == null) {
            model.addAttribute("condition", "请填写完整信息");
            //回到当前页面
            return "register";
        }
        //通过学号来查询是否已报名，并检查学号是否符合格式
        else if (userService.findUserByUId(user.getUId()) != null) {
            model.addAttribute("condition", "你已报名过 或 学号格式有误");
            return "register";
        }
        userService.insertUser(user);
        //获取主键值需通过访问对象获取，而不是通过函数返回值获取
        //System.out.println(user.getId());
        model.addAttribute("condition", "报名成功");
        return "result";
    }

    /**
     * 查询结果
     */
    @GetMapping("/result/{uId}")
    public String result(@PathVariable("uId") String uId,Model model){
        User user = userService.findUserByUId(uId);
        model.addAttribute("condition",user.getResult());
        return "result";
    }

    /**
     * 查询信息
     */
    @GetMapping("/learn/{uId}")
    public String learn(@PathVariable("uId") String uId,Model model){
        User user = userService.findUserByUId(uId);
        model.addAttribute("user",user);
        return "update";
    }

    /**
     * 用户修改信息
     */
    @PostMapping("/update")
    public String update(User user, Model model) {
        System.out.println(user);
        if (user.getUserName() == null || user.getUId() == null || user.getMajor() == null || user.getResume() == null) {
            model.addAttribute("condition", "请填写有效信息");
            //回到当前页面
            return "update";
        }
        userService.updateUser(user);
        model.addAttribute("condition", "修改成功");
        return "update";
    }

}
