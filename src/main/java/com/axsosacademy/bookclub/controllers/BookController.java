package com.axsosacademy.bookclub.controllers;

import com.axsosacademy.bookclub.models.Book;
import com.axsosacademy.bookclub.services.BookService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {

    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book, HttpSession session) {
        if (session.getAttribute("loggedUser") != null) {
            return "booksNew";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/books/new/addBook")
    public String addNewBook(
            @Valid @ModelAttribute("book") Book book,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "booksNew";
        }
        else {
            bookService.addBook(book);
            return "redirect:/books";
        }
    }

    @GetMapping("/books/{bookId}")
    public String showBook(
            @PathVariable Long bookId,
            Model model,
            HttpSession session
    ) {
        if (session.getAttribute("loggedUser") != null) {
            Book book = bookService.getBookById(bookId);
            model.addAttribute("book", book);
            return "booksShow";
        } else {
            return "redirect:/";
        }
    }

}
