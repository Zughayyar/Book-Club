package com.axsosacademy.bookclub.services;

import com.axsosacademy.bookclub.models.Book;
import com.axsosacademy.bookclub.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Get All Books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Add new Book
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    // Get Book by ID:
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

}
