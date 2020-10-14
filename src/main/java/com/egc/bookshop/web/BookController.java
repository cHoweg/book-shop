package com.egc.bookshop.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.egc.bookshop.entity.Book;
import com.egc.bookshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @PROJECT_NAME: item_BookShop
 * @DESCRIPTION:图书控制器
 * @USER: eugenechow
 * @DATE: 2020/8/30 10:01 下午
 */

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/index")
    public String index() {
//        System.out.println("index调用");

        return "index";
    }

    @RequestMapping("/getBookData")
    public String getBookData(Model model, Integer page, Integer category) {
        // mybatis plus分页
        System.out.println("调用了");
        IPage<Book> iPage = bookService.page(new Page<>(page, 4),
                new QueryWrapper<Book>().eq("category", category));
        model.addAttribute("bookList", iPage.getRecords());
        model.addAttribute("pre", iPage.getCurrent() - 1);
        model.addAttribute("next", iPage.getCurrent() + 1);
        model.addAttribute("category", category);
        model.addAttribute("cur", iPage.getCurrent());
        model.addAttribute("last", iPage.getPages());
        return "bookData";
    }

    // 图书列表页
    @RequestMapping("/bookList")
    public String bookList(String category, Model model) {
        model.addAttribute("category", category);
        return "books_list";
    }

    // 获取图书列表数据
    @RequestMapping("/getBookListData")
    public String getBookListData(Integer page, Integer pageSize, Integer category, Model model) {
        IPage<Book> iPage = bookService.page(new Page<>(page, pageSize),
                new QueryWrapper<Book>().eq("category", category));
        model.addAttribute("bookList", iPage.getRecords());
        model.addAttribute("pre", iPage.getCurrent() - 1);
        model.addAttribute("next", iPage.getCurrent() + 1);
        model.addAttribute("category", category);
        model.addAttribute("cur", iPage.getCurrent());
        model.addAttribute("pages", iPage.getPages());
        model.addAttribute("pageSize", pageSize);
        return "booksListData";
    }

    // 图书详情
    @RequestMapping("/detail")
    public String detail(Integer id,Model model){
        Book book = bookService.getById(id);
        model.addAttribute("book",book);
        return "details";
    }
}
