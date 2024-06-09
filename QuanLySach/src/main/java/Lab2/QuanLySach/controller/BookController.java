package Lab2.QuanLySach.controller;

import Lab2.QuanLySach.model.Book;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {
    @Autowired
    private List<Book> listBooks;
    @GetMapping("/")
    public String showAllBooks(Model model) {
        model.addAttribute("listBooks", listBooks);
        model.addAttribute("title", "Danh sách cuốn sách");
        return "book/list";
    }
    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "book/add";
    }
    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
        if(result.hasErrors()) {return "book/add";}
        listBooks.add(book);
        return "redirect:/";
    }

    @GetMapping("/book/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        listBooks.removeIf(book -> book.getId() == id);
        return "redirect:/";
    }

    @GetMapping("/book/edit/{id}")
    public String editBookForm(@PathVariable int id, Model model) {
        Optional<Book> bookOpt = listBooks.stream().filter(b -> b.getId() == id).findFirst();
        if (bookOpt.isPresent()) {
            model.addAttribute("book", bookOpt.get());
            return "book/edit";
        }
        return "redirect:/";
    }

    @PostMapping("/book/edit/{id}")
    public String editBook(@PathVariable int id, @Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "book/edit";
        }
        listBooks.removeIf(b -> b.getId() == id);
        listBooks.add(book);
        return "redirect:/";
    }
}
