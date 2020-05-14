package com.example.home.bootspring.aspect;

import com.example.home.bootspring.config.Webconfig;

import com.example.home.bootspring.model.Post;
import com.example.home.bootspring.service.PostService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Aspect
@Component
public class WebconfigAspect {

    private static Logger logger = LoggerFactory.getLogger(Webconfig.class);

    public WebconfigAspect(PostService postService) {
        this.postService = postService;
    }

    private PostService postService;

    @Before("execution(* *.showAllPosts(..))")
    public void logging(JoinPoint joinpoint) {

        Object[] objects = joinpoint.getArgs();

        logger.info("Current Time :" + LocalDateTime.now()+" "+
        joinpoint.getSignature().getName()
                +
        "callwith : " + objects);
    }


    @Before("execution(* *.findbyid(..))")
    public void notFoundAspect(JoinPoint joinPoint){






    }


}
