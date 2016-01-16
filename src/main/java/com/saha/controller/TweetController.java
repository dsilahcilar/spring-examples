package com.saha.controller;

import com.saha.annotations.JsonRestController;
import com.saha.model.User;
import com.saha.persistence.entity.TweetEntity;
import com.saha.service.TweetService;
import com.saha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@JsonRestController
@RequestMapping(value = "/users/{id}/tweets")
public class TweetController {
    @Autowired
    private TweetService tweetService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Iterable<TweetEntity> create(@RequestBody TweetEntity tweet, @PathVariable(value = "id") Long userId) {
        return tweetService.save(tweet,userId);
    }


    @RequestMapping(method = RequestMethod.GET)
    public Collection<User> users() {
      //  return tweetService.users();
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public User user(@PathVariable Long id) {
       // return tweetService.users(id);
        return null;
    }


    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public User update(@RequestBody User user, @PathVariable Long id) {
        return null;
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        tweetService.delete(id);
    }

}
