package com.library;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository 
{
    public void save(String bookTitle) 
    {
        // Simulate saving the book
        System.out.println("Saving book: " + bookTitle);
    }
}
