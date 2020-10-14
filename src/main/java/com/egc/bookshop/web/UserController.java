package com.egc.bookshop.web;

/**
 * @PROJECT_NAME: item_BookShop
 * @DESCRIPTION:
 * @USER: eugenechow
 * @DATE: 2020/9/2 8:02 下午
 */

import com.egc.bookshop.entity.User;
import com.egc.bookshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // 验证用户名是否存在
    @RequestMapping("/checkUserName")
    @ResponseBody
    public String checkUserName(String username) {
        return userService.checkUser(username);
    }

    // 用户注册
    @RequestMapping("/register")
    @ResponseBody
    public String register(User user) {
        boolean save = userService.save(user);
        if (save == true) {
            return "success";
        }else {
            return "fail";
        }
    }

    // 用户登录
    @RequestMapping("/login")
    @ResponseBody
    public String login(User user, HttpSession session){
        return userService.loginCheck(user,session);
    }

    // 安全退出
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "index";
    }
}
