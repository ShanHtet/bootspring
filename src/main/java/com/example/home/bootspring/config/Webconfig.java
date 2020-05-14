package com.example.home.bootspring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

@Configuration
@ControllerAdvice
public class Webconfig implements WebMvcConfigurer {

    private static Logger logger = LoggerFactory
            .getLogger(Webconfig.class);


    @ExceptionHandler({EntityNotFoundException.class, ConstraintViolationException.class})
    public ModelAndView handleNotFoundException(HttpServletRequest request
            , Exception ex){
        logger.info("Exception type:"+ ex);
        ModelAndView mv=new ModelAndView();
        mv.addObject("message",ex.getMessage());
        mv.addObject("exception",ex);
        mv.addObject("url",request.getRequestURL());
        mv.setViewName("postNotFound");
        return mv;
    }



    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/","/posts");
    }

}
