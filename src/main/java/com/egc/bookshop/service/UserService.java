package com.egc.bookshop.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.egc.bookshop.entity.User;
import com.egc.bookshop.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @PROJECT_NAME: item_BookShop
 * @DESCRIPTION:
 * @USER: eugenechow
 * @DATE: 2020/9/2 8:08 下午
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> {
    @Autowired
    private UserMapper userMapper;

    /**
     * 验证用户的存在性
     */
    public String checkUser(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        User user = userMapper.selectOne(queryWrapper);
        if (user == null) {
            return "101";// 不存在
        } else {
            return "102"; // 已存在
        }
    }

    /**
     * 登录验证
     */
    public String loginCheck(User loginUser, HttpSession session) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", loginUser.getUsername());
        User user = userMapper.selectOne(queryWrapper);
        if (user == null) {
            return "101";
        } else {
            if (loginUser.getPassword().equals(user.getPassword())) {
                session.setAttribute("user",user);
                return "100";
            } else {
                return "102"; // 密码不正确
            }
        }
    }
}
