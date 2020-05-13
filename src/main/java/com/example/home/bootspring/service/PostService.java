package com.example.home.bootspring.service;

import com.example.home.bootspring.model.Author;
import com.example.home.bootspring.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {


    Post create(Post post);

    Post findById(Integer id);

    List<Post> findall();

    void update(Integer id,Post post);

    void delete(Integer id);



}
