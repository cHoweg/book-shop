package com.egc.bookshop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @PROJECT_NAME: item_BookShop
 * @DESCRIPTION:
 * @USER: eugenechow
 * @DATE: 2020/9/1 12:22 下午
 */

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("public/**").addResourceLocations("file:///Users/eugenechow/Documents/IDEA_ITEM/item_BookShop/book-shop/src/main/resources/static/images/");
    }
}
