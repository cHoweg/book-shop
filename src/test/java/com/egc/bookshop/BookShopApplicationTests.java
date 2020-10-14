package com.egc.bookshop;

import com.egc.bookshop.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class BookShopApplicationTests {

	@Autowired
	private BookService bookService;

	@Test
	void contextLoads() {
		bookService.list().forEach(System.out::println);
	}

}
