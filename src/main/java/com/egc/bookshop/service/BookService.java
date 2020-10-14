package com.egc.bookshop.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.egc.bookshop.entity.Book;
import com.egc.bookshop.mapper.BookMapper;
import org.springframework.stereotype.Service;

/**
 * @PROJECT_NAME: item_BookShop
 * @DESCRIPTION:图书业务层
 * @USER: eugenechow
 * @DATE: 2020/8/30 9:39 下午
 */

@Service
public class BookService extends ServiceImpl<BookMapper, Book> {
}
