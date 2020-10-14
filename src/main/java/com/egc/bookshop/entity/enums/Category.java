package com.egc.bookshop.entity.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @PROJECT_NAME: item_BookShop
 * @DESCRIPTION:图书类型枚举类
 * @USER: eugeneChow
 * @DATE: 2020/8/30 4:50 下午
 */

@Getter
public enum Category {
    SELECTED(1, "精选图书"), RECOMMEND(2, "推荐图书"), BARGAIN(3, "特价图书");

    @EnumValue // 标记数据库存的值是code
    private final int code;
    private final String desc;

    Category(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
