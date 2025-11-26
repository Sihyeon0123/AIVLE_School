package com.example.book.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.book.domain.Book;
import com.example.book.service.BookService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    public final BookService bookService;
    
    // 책 등록 POST /books
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.insertBook(book);   
    }

    // 책 수정 PUT /books/{id}
    @GetMapping("/{id}")
    public void updateBook(@PathVariable("id") Long id, @RequestBody Book book) {
        bookService.updateBook(id, book);
    }
    
    // 책 수정 PATCH /books/{id}/status
    @GetMapping("/{id}/status")
    public Book updateBookStatus(@PathVariable("id") Long id, @RequestBody Book.Status status) {
        return bookService.updateBook(id, status);
    }
    
    // 책 삭제 DELETE /books/{id}
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }
    
    // 책 단건 조회 GET /books/{id}
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") Long id) {
        return bookService.getBookById(id);
    }
    
    // 책 전체 조회 GET /books
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
}