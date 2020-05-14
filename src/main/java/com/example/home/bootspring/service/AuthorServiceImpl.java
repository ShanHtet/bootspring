package com.example.home.bootspring.service;

import com.example.home.bootspring.model.Author;
import com.example.home.bootspring.repo.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AuthorServiceImpl implements  AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public Author create(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author findbyid(Integer id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Author> findall() {
        return authorRepository.findAll();
    }
}
