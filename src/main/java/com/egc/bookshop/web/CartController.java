package com.egc.bookshop.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.egc.bookshop.entity.Cart;
import com.egc.bookshop.entity.CartVo;
import com.egc.bookshop.entity.User;
import com.egc.bookshop.entity.UserCartVo;
import com.egc.bookshop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @PROJECT_NAME: item_BookShop
 * @DESCRIPTION:购物车控制器
 * @USER: eugenechow
 * @DATE: 2020/9/4 8:43 下午
 */

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    // 加入购物车
    @RequestMapping("/add")
    @ResponseBody
    public String add(Cart cart, HttpSession session) {
        User user = (User) session.getAttribute("user");
        cart.setUserId(user.getId());
        // 判断是否已经在购物车存在该物品
        QueryWrapper<Cart> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", user.getId());
        queryWrapper.eq("book_id", cart.getBookId());
        Cart cartServiceOne = cartService.getOne(queryWrapper);
        if (cartServiceOne == null) {
            cartService.save(cart);
        } else {
            cartServiceOne.setCount(cartServiceOne.getCount() + cart.getCount());
            cartService.updateById(cartServiceOne);
        }
        return "success";
    }


    // 查询当前用户的购物车
    @RequestMapping("/list")
    public String list(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        List<CartVo> cartVoList = cartService.findCartByUser(user.getId());

        // 将购物车存放到session中
        UserCartVo userCartVo = cartService.wrapperCart(cartVoList);
        session.setAttribute("userCartInfo", userCartVo);
        model.addAttribute("cartList", cartVoList);
        return "cart";
    }

    // 更新购物车信息
    @ResponseBody
    @RequestMapping("/update")
    public String update(HttpSession session, Cart cart) {
        cartService.updateById(cart);
        User user = (User) session.getAttribute("user");
        List<CartVo> cartVoList = cartService.findCartByUser(user.getId());

        UserCartVo userCartVo = cartService.wrapperCart(cartVoList);
        session.setAttribute("userCartInfo", userCartVo);

        double price = cartService.getCartItemTotal(cartVoList);
        return String.valueOf(price);
    }

    // 删除购物车信息
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(String ids) {
        return cartService.batchDelete(ids);
    }
}
