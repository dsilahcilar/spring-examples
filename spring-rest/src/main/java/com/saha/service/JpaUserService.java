package com.saha.service;

import com.saha.annotations.TestProfile;
import com.saha.model.User;
import com.saha.persistence.entity.UserEntity;
import com.saha.persistence.repository.UserRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@TestProfile
public class JpaUserService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DozerBeanMapper mapper;


    @Override
    @Cacheable(value = "allusers")
    public Collection<User> users() {
        Iterable<UserEntity> userEntities = userRepository.findAll();
        List<User> users = new ArrayList<>();
        for (UserEntity userEntity : userEntities) {
            User user = new User();
            mapper.map(userEntity, user);
            users.add(user);
        }
        return users;
    }

    @Override
    public User findBy(String param) {
        Collection<UserEntity> userEntities = userRepository.findByLastName(param);
        for (UserEntity userEntity : userEntities) {
            System.out.println("userEntity = " + userEntity);
        }

        User user = new User();
        mapper.map(null, user);
        return user;
    }

    @Override
    @Cacheable(value = "users", condition = "#id > 20")
    public User users(Long id) {
        UserEntity foundedUser = userRepository.findOne(id);
        User user = new User();
        mapper.map(foundedUser, user);
        return user;
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = new UserEntity();
        mapper.map(user, userEntity);
        userEntity = userRepository.save(userEntity);

        User savedUser = new User();
        mapper.map(userEntity, savedUser);

        return savedUser;
    }


    @Override
    @CacheEvict(value = {"users", "allusers"}, allEntries = true)
    public Boolean delete(Long id) {
        userRepository.delete(id);
        return true;
    }


    @Override
    public User update(Long id, User user) {
        UserEntity foundedUser = userRepository.findOne(id);

        user.setTcKimlik(foundedUser.getId().toString());
        mapper.map(user, foundedUser);

        userRepository.save(foundedUser);

        mapper.map(foundedUser, user);

        return user;
    }
}
