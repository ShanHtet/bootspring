package com.example.home.bootspring.service;

import com.example.home.bootspring.model.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService   {

    Author create(Author author);

    Author findbyid(Integer id);

    List<Author> findall();



}
