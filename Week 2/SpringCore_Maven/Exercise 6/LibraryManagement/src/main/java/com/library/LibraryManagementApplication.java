package com.library;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication 
{
    public static void main(String[] args) 
    {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        try 
        {
            BookService bookService = (BookService) context.getBean("bookService");
            bookService.addBook("Spring in Action");
        } 
        finally 
        {
            context.close();
        }
    }
}
