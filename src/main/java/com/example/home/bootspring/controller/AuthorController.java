package com.example.home.bootspring.controller;
import com.example.home.bootspring.model.Author;
import com.example.home.bootspring.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@Controller
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping("/author")
    public String create(Model model){
        model.addAttribute("author",new Author());
                return "authorForm";
    }

    @PostMapping("/author")
    public String process(@Valid Author author, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            return "authorForm";
        }

        authorService.create(author);

        redirectAttributes.addFlashAttribute("success",true);

        return "redirect:/authors";
    }


    @GetMapping("/authors")
    public String showAllAuthors(Model model){
        model.addAttribute("authors",authorService.findall());
        model.addAttribute("success",model.containsAttribute("success"));

        return "authors";
    }



//    @ExceptionHandler
//    ResponseEntity<String> handleExc(EntityNotFoundException e){
//        return  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
//    }



}
