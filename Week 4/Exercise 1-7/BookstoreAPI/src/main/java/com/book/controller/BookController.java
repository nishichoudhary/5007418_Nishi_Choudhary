package com.book.controller;

import com.book.dto.BookDTO;
import com.book.model.Book;
import com.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO createBook(@RequestBody BookDTO bookDTO) {
        // Convert DTO to entity
        Book book = bookService.convertToEntity(bookDTO);
        // Simulate saving the book entity (replace with actual database save logic)
        // For now, just returning the same book as DTO
        return bookService.convertToDTO(book);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable int id) {
        // Simulate fetching the book entity by ID (replace with actual database fetch logic)
        Book book = fetchBookFromDatabase(id); // This is a placeholder for actual DB fetch
        if (book != null) {
            return new ResponseEntity<>(bookService.convertToDTO(book), HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
        }
    }

    @GetMapping("/search")
    public List<BookDTO> searchBooks(@RequestParam(required = false) String title,
                                     @RequestParam(required = false) String author) {
        // Simulate fetching the book entities (replace with actual database fetch logic)
        List<Book> books = fetchBooksFromDatabase(); // This is a placeholder for actual DB fetch
        return books.stream()
                .filter(book -> (title == null || book.getTitle().equalsIgnoreCase(title)) &&
                                (author == null || book.getAuthor().equalsIgnoreCase(author)))
                .map(bookService::convertToDTO)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable int id, @RequestBody BookDTO updatedBookDTO) {
        // Convert DTO to entity
        Book updatedBook = bookService.convertToEntity(updatedBookDTO);
        // Simulate updating the book entity (replace with actual database update logic)
        Book book = updateBookInDatabase(id, updatedBook); // This is a placeholder for actual DB update
        if (book != null) {
            return new ResponseEntity<>(bookService.convertToDTO(book), HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable int id) {
        // Simulate deleting the book entity (replace with actual database delete logic)
        deleteBookFromDatabase(id); // This is a placeholder for actual DB delete
    }

    // Placeholder methods for simulating database operations
    private Book fetchBookFromDatabase(int id) {
        // Implement actual DB fetch logic here
        return null;
    }

    private List<Book> fetchBooksFromDatabase() {
        // Implement actual DB fetch logic here
        return List.of();
    }

    private Book updateBookInDatabase(int id, Book updatedBook) {
        // Implement actual DB update logic here
        return null;
    }

    private void deleteBookFromDatabase(int id) {
        // Implement actual DB delete logic here
    }
}
