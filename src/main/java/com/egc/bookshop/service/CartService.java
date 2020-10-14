package com.egc.bookshop.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.egc.bookshop.entity.Cart;
import com.egc.bookshop.entity.CartVo;
import com.egc.bookshop.entity.UserCartVo;
import com.egc.bookshop.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

/**
 * @PROJECT_NAME: item_BookShop
 * @DESCRIPTION:
 * @USER: eugenechow
 * @DATE: 2020/9/4 8:49 下午
 */
@Service
public class CartService extends ServiceImpl<CartMapper, Cart> {
    @Autowired
    private CartMapper cartMapper;

    // 根据用户查询购物车记录
    public List<CartVo> findCartByUser(Integer userId){
        return cartMapper.findCartListByUserId(userId);
    }

    // 根据购物车id查询对应记录
    public List<CartVo> findCartListByIds(String ids) {
        return cartMapper.findCartListByIds(Arrays.asList(ids));
    }

    // 统计当前用户购物车的总计
    public double getCartItemTotal(List<CartVo> list){
        double sum = 0.0;
        for (CartVo cart :
                list) {
            sum += cart.getCount() * cart.getNewPrice();
        }
        return sum;
    }

    // 批量删除
    public String batchDelete(String ids) {
        if (ids != null) {
            String[] idArray = ids.split(",");
            cartMapper.deleteBatchIds(Arrays.asList(idArray));
        }
        return "success";
    }


    // 包装用户购物车信息
    public UserCartVo wrapperCart(List<CartVo> cartVoList){
        UserCartVo userCartVo = new UserCartVo();
        userCartVo.setNum(cartVoList.size());
        userCartVo.setTotalPrice(getCartItemTotal(cartVoList));
        return userCartVo;
    }
}
