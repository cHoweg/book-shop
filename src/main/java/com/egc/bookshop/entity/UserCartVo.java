package com.egc.bookshop.entity;

import lombok.Data;

/**
 * @PROJECT_NAME: item_BookShop
 * @DESCRIPTION: 用户购物车信息展示对象
 * @USER: eugenechow
 * @DATE: 2020/9/5 12:52 下午
 */

@Data
public class UserCartVo {
    private Integer num;
    private double totalPrice;
}
