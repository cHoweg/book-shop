package com.egc.bookshop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.egc.bookshop.entity.enums.Category;
import com.egc.bookshop.entity.enums.Suit;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

// 图书实体类
@Data
@TableName("bs_book")
public class Book extends Model<Book> {

    // 自增加
    @TableId(type = IdType.ASSIGN_ID)
    private Integer id;

    private String isbn;

    private String name;

    private String author;

    private String publisher;

    private Date publishDate;

    private double oldPrice;

    private double newPrice;

    private String authorLoc;

    private Suit suit;

    private Category category;

    private String info;

    private String imgUrl;

}