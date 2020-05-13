package com.example.home.bootspring;

import com.example.home.bootspring.model.Author;
import com.example.home.bootspring.model.Gender;
import com.example.home.bootspring.model.Post;
import com.example.home.bootspring.repo.AuthorRepository;
import com.example.home.bootspring.repo.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;

@SpringBootApplication
public class BootspringApplication {

    

    public static void main(String[] args) {
        SpringApplication.run(BootspringApplication.class, args);
    }



////    private static Logger logger
////            = LoggerFactory.getLogger(BootspringApplication.class);
////
////    @Bean
////    public CommandLineRunner runner(AuthorRepository authorRepository, PostRepository postRepository){
////        return  args ->
////        {
////            Author a1 = new Author("MGMG", LocalDate.of(2000,3,12),"Basket", Gender.MALE);
////            Author a2 = new Author("HAHA", LocalDate.of(2000,3,12),"Basket", Gender.MALE);
////
////            Post p1= new Post("Poll","hello from adf adfw ",LocalDate.of(2001,12,1));
////            Post p2= new Post("UUR","hello from adf adfw ",LocalDate.of(2001,12,1));
////            Post p3= new Post("HOW","hello from adf adfw ",LocalDate.of(2001,12,1));
////
////            p1.setAuthor(a1);
////            p2.setAuthor(a2);
////            p3.setAuthor(a2);
////
////            authorRepository.save(a1);
////            authorRepository.save(a2);
////            postRepository.save(p1);
////            postRepository.save(p2);
////            postRepository.save(p3);
////
////            logger.info("SUCCESSFULLY CREATEDD");
////
////
////        };
//
//
//
//    }


}
