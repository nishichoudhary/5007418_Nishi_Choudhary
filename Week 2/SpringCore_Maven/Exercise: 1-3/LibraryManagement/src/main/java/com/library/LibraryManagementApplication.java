package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class LibraryManagementApplication 
{
    public static void main(String[] args) 
    {
        // Load Spring context
        @SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get BookService bean
        BookService bookService = (BookService) context.getBean("bookService");

        // Test the configuration
        bookService.addBook("Spring in Action");
    }
}
