package com.egc.bookshop.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.egc.bookshop.entity.Address;
import com.egc.bookshop.entity.CartVo;
import com.egc.bookshop.entity.User;
import com.egc.bookshop.service.AddressService;
import com.egc.bookshop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @PROJECT_NAME: item_BookShop
 * @DESCRIPTION: 订单控制器
 * @USER: eugenechow
 * @DATE: 2020/9/5 3:42 下午
 */

@Controller
@RequestMapping("/order")
public class OrdController {
    @Autowired
    private CartService cartService;
    @Autowired
    private AddressService addressService;

    // 确认订单
    @RequestMapping("/confirm")
    public String confirm(String ids, HttpSession session, Model model) {
        // 查询记录
        List<CartVo> cartVos = cartService.findCartListByIds(ids);

        // 获取用户当前收货地址
        QueryWrapper<Address> wrapper = new QueryWrapper<>();
        User user = (User) session.getAttribute("user");
        wrapper.eq("user_id",user.getId());
        List<Address> addressList = addressService.list(wrapper);
        model.addAttribute("list", cartVos);
        model.addAttribute("addressList",addressList);
        return "confirm_order";
    }
}