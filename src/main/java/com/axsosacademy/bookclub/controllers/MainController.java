package com.axsosacademy.bookclub.controllers;

import com.axsosacademy.bookclub.models.Book;
import com.axsosacademy.bookclub.models.LoginUser;
import com.axsosacademy.bookclub.models.User;
import com.axsosacademy.bookclub.services.BookService;
import com.axsosacademy.bookclub.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    private final UserService userService;
    private final BookService bookService;
    public MainController(UserService userService, BookService bookService) {
        this.userService = userService;
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index";
    }

    @GetMapping("/books")
    public String books(HttpSession session, Model model) {
        if (session.getAttribute("loggedUser") != null) {
            List<Book> books = bookService.getAllBooks();
            model.addAttribute("books", books);
            return "books";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }




}
