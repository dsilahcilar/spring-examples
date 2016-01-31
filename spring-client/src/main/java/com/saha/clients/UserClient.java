package com.saha.clients;

import com.saha.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class UserClient {
    @Autowired
    private RestTemplate restTemplate;

    public User user(Long userId) {

        ResponseEntity<User> userResponseEntity = restTemplate
                .getForEntity("http://localhost:8080/users/" + userId, User.class);

        User user = userResponseEntity.getBody();
        return user;
    }

    public List<User> users() {
        ResponseEntity<User[]> userResponseEntity = restTemplate
                .getForEntity("http://localhost:8080/users/", User[].class);
        User[] userArray = userResponseEntity.getBody();
        return Arrays.asList(userArray);
    }

    public User addUser(User user) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("myHeader", "myValue");

        httpHeaders.set("userNAme", "username");
        httpHeaders.set("password", "password");


        HttpEntity<User> entity = new HttpEntity<User>(user, httpHeaders);


        ResponseEntity<User> response = restTemplate
                .postForEntity("http://localhost:8080/users/", entity, User.class);
        return response.getBody();
    }

    public void deleteUser(Long userId) {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:8080/users/" + userId)
                .build()
                .toUri();

        restTemplate.delete(uri);
    }


















    public void addUserDeneme(User user) {
        User user1 = new User();
        user1.setLastName("deneme");
        user1.setName("denemeName");
        user1.setUserName("denemeusername");

        HttpHeaders headers = new HttpHeaders();
        headers.set("deneme", "denemeValue");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<User> entity = new HttpEntity<User>(user, headers);


        restTemplate.postForEntity("http://localhost:8080/users/", entity, User.class);
    }


}
