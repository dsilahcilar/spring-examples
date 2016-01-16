package com.saha.controller;

import com.saha.model.TweetError;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserControllerAdvice {


    @ExceptionHandler(value = DataIntegrityViolationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public TweetError handler() {
        TweetError tweetError = new TweetError();
        tweetError.setCode(99L);
        tweetError.setDescription("Bir hata oluştu");
        return tweetError;
    }

}
