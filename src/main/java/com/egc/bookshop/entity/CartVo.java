package com.egc.bookshop.entity;

import lombok.Data;

/**
 * @PROJECT_NAME: item_BookShop
 * @DESCRIPTION:
 * @USER: eugenechow
 * @DATE: 2020/9/4 9:18 下午
 */

@Data
public class CartVo {
    private Integer id;
    private Integer userId;
    private Integer bookId;
    private Integer count;
    private String bookName;
    private String imgUrl;
    private double newPrice;
}
