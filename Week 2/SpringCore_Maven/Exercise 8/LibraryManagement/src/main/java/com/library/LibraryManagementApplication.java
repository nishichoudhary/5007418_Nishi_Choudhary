package com.library;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;


public class LibraryManagementApplication
{
    public static void main(String[] args) 
    {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService service=context.getBean(BookService.class);
        service.displayBookRepository();
        context.close();
    }
}