package com.saha.service;

import com.saha.annotations.TestProfile;
import com.saha.model.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
@TestProfile
public class MemoryUserService implements UserService{
    private static final Map<Long, User> users = new HashMap<>();

    public Collection<User> users() {
        return users.values();
    }

    public User users(Long id) {
        return users.get(id);
    }

    @Override
    public User save(User user) {
        Long id = users.size() + 1l;
        user.setTcKimlik(id.toString());
        users.putIfAbsent(id,user);
        return users.get(id);
    }

    public Boolean delete(Long id) {
        return users.remove(id) != null;
    }

    public User update(Long id, User user) {
        User currentUser = users.get(id);
        currentUser.setName(user.getName());
        currentUser.setLastName(user.getLastName());
        currentUser.setUserName(user.getUserName());
        return currentUser;
    }

    @Override
    public User findBy(String lastName) {
        return null;
    }
}
