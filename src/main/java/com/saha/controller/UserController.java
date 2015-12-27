package com.saha.controller;

import com.saha.model.User;
import com.saha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<User> users() {
        return userService.users();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public User user(@PathVariable Long id) {
        return userService.users(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return userService.save(user);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public User update(@RequestBody User user, @PathVariable Long id) {
        return userService.update(id, user);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

}
