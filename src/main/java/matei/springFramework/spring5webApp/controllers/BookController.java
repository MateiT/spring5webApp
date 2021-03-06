package matei.springFramework.spring5webApp.controllers;

import matei.springFramework.spring5webApp.repositories.BookRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookRepo bookRepo;

    public BookController(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @RequestMapping(path = "/books")
    public String getBooks(Model model){
        model.addAttribute("books", bookRepo.findAll());
        return "books/list";
    }
}
