package com.egc.bookshop.entity.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @PROJECT_NAME: item_BookShop
 * @DESCRIPTION:套装枚举类
 * @USER: eugenechow
 * @DATE: 2020/8/30 4:57 下午
 */

@Getter
public enum Suit {
    YES(1,"是"),NO(2,"否");

    @EnumValue // 标记数据库存的值是code
    private final int code;
    private final String desc;

    Suit(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
