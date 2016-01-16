package com.saha.service;

import com.saha.annotations.TestProfile;
import com.saha.model.User;
import com.saha.persistence.entity.TweetEntity;
import com.saha.persistence.entity.UserEntity;
import com.saha.persistence.repository.UserRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@TestProfile
public class TweetService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DozerBeanMapper mapper;

    public Collection<TweetEntity> tweets() {

        return null;
    }

    public User users(Long id) {
        return null;
    }

    public Iterable<TweetEntity> save(TweetEntity tweet, Long userId) {
        UserEntity userEntity = userRepository.findOne(userId);

        userEntity.getTweets().add(tweet);
        tweet.setUserEntity(userEntity);

        userEntity = userRepository.save(userEntity);

        return userEntity.getTweets();
    }

    public Boolean delete(Long id) {
        return null;
    }

    public User update(Long id, User user) {
        return null;
    }
}
