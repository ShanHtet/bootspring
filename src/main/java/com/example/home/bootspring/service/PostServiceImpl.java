package com.example.home.bootspring.service;
import com.example.home.bootspring.model.Post;
import com.example.home.bootspring.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;


    @Override
    public Post create(Post post) {
        return postRepository.save(post);
    }


    @Override
    public Post findById(Integer id) {
        return postRepository.findById(id).orElseThrow(()->new EntityNotFoundException());
    }


    @Override
    public List<Post> findall() {
        return postRepository.findAll();
    }


    @Override
    @Transactional
    public void update (Integer id, Post postupdated){
        Post post= findById(id);
        post.setAuthor(postupdated.getAuthor());
        post.setBody(postupdated.getBody());
        post.setLastUpdate(postupdated.getLastUpdate());
        post.setTag(postupdated.getTag());
    }

    @Override
    public void delete(Integer id) {
                postRepository.deleteById(id);
    }


}
