package com.example.TH_buoi3.controller;

import com.example.TH_buoi3.entity.Book;
import com.example.TH_buoi3.entity.Category;
import com.example.TH_buoi3.services.BookService;
import com.example.TH_buoi3.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String showAllBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books",books);
        return "book/list";
    }
    @GetMapping("/add")
    public String addBookForm(Model model)
    {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryService.getAllCategories());
        return"book/add";
    }
    @PostMapping("/add")
    public String addBook(@ModelAttribute("book") Book book){
        bookService.addBook(book);
        return "redirect:/books";
    }
    @GetMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
