package com.egc.bookshop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * @PROJECT_NAME: item_BookShop
 * @DESCRIPTION:
 * @USER: eugenechow
 * @DATE: 2020/9/4 8:44 下午
 */
@Data
@TableName("bs_cart")
public class Cart extends Model<Cart> {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private Integer bookId;
    private Integer count;

    // 屏蔽book属性和数据库表中字段映射
    @TableField(exist = false)
    private Book book;
}
