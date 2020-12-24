package com.egc.bookshop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * @PROJECT_NAME: item_BookShop
 * @DESCRIPTION:
 * @USER: eugenechow
 * @DATE: 2020/9/5 7:22 下午
 */

@Data
@TableName("bs_address")
public class Address extends Model<Address> {
    private Integer id;
    private Integer userId;
    private String province;
    private String city;
    private String area;
    private String detailAddress;
    private String emailCode;
    private String receiver;
    private String tel;
    private String isDefault;

}
