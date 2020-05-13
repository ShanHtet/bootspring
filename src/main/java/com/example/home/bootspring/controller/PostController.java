package com.example.home.bootspring.controller;

import com.example.home.bootspring.model.Post;
import com.example.home.bootspring.service.AuthorService;
import com.example.home.bootspring.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private AuthorService authorService;


    @GetMapping("/post")
    public String create(Model model){
        model.addAttribute("post",new Post());
        model.addAttribute("authors",authorService.findall());
        return "postForm";

    }

    @PostMapping("/post")
    public String process(@Valid Post post, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "postForm";
        }
        postService.create(post);
        return "redirect:/posts";
    }


    @GetMapping("/posts")
    public String showAllPosts(Model model){
        model.addAttribute("allposts",postService.findall());
        model.addAttribute("success",model.containsAttribute("success"));
        return "posts";
    }

    @GetMapping("/posts/update/{id}")
    public String updatePost(@PathVariable("id") Integer id,Model model){
        this.updateId=id;
        model.addAttribute("post",postService.findById(id));
        model.addAttribute("authors",authorService.findall());
        return "postUpdateForm";
    }

    @PostMapping("/posts/update")
    public String processPost(Post post, RedirectAttributes redirectAttributes){
        postService.update(updateId,post);
        redirectAttributes.addFlashAttribute("success",true);
        return "redirect:/posts";
    }

    private Integer updateId;


    @GetMapping("/post/delete/{id}")
    public  String deletePost(@PathVariable("id") Integer id){
        postService.delete(id);
        return "redirect:/posts";
    }

//    @ExceptionHandler
//    public ResponseEntity<String> handleNotFoundExc(EntityNotFoundException e){
//        return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
//    }

}
