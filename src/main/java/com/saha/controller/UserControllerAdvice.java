package com.saha.controller;

import com.saha.annotations.JsonRestController;
import com.saha.model.TweetError;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(annotations = JsonRestController.class)
public class UserControllerAdvice {

 //   @ExceptionHandler(value = DataIntegrityViolationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public TweetError handler() {
        TweetError tweetError = new TweetError();
        tweetError.setCode(99L);
        tweetError.setDescription("Varolan bir kayıt eklemeye calistiniz");
        return tweetError;
    }

   // @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public TweetError allHandler() {
        TweetError tweetError = new TweetError();
        tweetError.setCode(100L);
        tweetError.setDescription("Beklenmeyen bir hata olustu.");
        return tweetError;
    }

}
