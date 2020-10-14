package com.egc.bookshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.egc.bookshop.entity.Book;


// 图书接口
public interface BookMapper extends BaseMapper<Book> {
    int deleteByPrimaryKey(Integer id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
}