package com.saha.service;

import com.saha.model.User;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface UserService {

    Collection<User> users();

    User users(Long id);

    User save(User User);


    Boolean delete(Long id);

    User update(Long id, User user);
}
