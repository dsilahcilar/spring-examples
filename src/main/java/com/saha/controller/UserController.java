package com.saha.controller;

import com.saha.annotations.JsonRestController;
import com.saha.model.User;
import com.saha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@JsonRestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    @Qualifier("jpaUserService")
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<User> users() {
        return userService.users();
    }

    @RequestMapping(params = "lastName", method = RequestMethod.GET)
    public User findUsers(@RequestParam String lastName) {
        return userService.findBy(lastName);
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
        if (id == 99) {
            throw new RuntimeException();
        }
        return userService.update(id, user);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

}
