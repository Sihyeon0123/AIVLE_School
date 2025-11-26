package com.example.book.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.book.domain.Book;
import com.example.book.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    // 책 등록
    public Book insertBook(Book book) {
        return bookRepository.save(book);
    }

    // 책 업데이트(PUT)
    public void updateBook(Long id, Book book) {
        Book existingBook = getBookById(id);
        existingBook.setTitle(book.getTitle());
        existingBook.setSubTitle(book.getSubTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setPublisher(book.getPublisher());
        existingBook.setStatus(book.getStatus());
        bookRepository.save(existingBook);
    }

    // 책 업데이트(PATCH)
    public Book updateBook(Long id, Book.Status status) {
        Book existingBook = getBookById(id);
        existingBook.setStatus(status);
        return existingBook;    
    }

    // 책 삭제(DELETE)
    public void deleteBook(Long id) {
        Book existingBook = getBookById(id);
        if(existingBook.getStatus() == Book.Status.BORROWED) {
            throw new IllegalStateException("Cannot delete a borrowed book");
        }
        bookRepository.delete(existingBook);
    }

    // 책 단건 조회(GET)
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
    }

    // 책 전체 조회(GET)
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}