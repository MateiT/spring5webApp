package matei.springFramework.spring5webApp.controllers;

import matei.springFramework.spring5webApp.repositories.AuthorRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {
    private final AuthorRepo authorRepo;

    public AuthorController(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    @RequestMapping(path = "/authors")
    public String getBooks(Model model){
        model.addAttribute("authors", authorRepo.findAll());
        return "authors/list";
    }
}
