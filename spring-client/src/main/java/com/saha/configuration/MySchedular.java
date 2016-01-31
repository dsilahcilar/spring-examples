package com.saha.configuration;

import com.saha.clients.UserClient;
import com.saha.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Calendar;
import java.util.List;

@Configuration
@Slf4j
public class MySchedular {

    @Autowired
    private UserClient userClient;

    @Scheduled(fixedRate = 1000 * 1)
    public void deneme() {
        int second = Calendar.getInstance().get(Calendar.SECOND);
        log.info("Calendar.getInstance().get(Calendar.SECOND) = " + second);

        List<User> users = userClient.users();
        System.out.println("===================");
        for (User user : users) {
            log.info("user = " + user);
        }

        User user = new User();
        user.setName("Deniz" + second);
        user.setLastName("Sil" + second + 1);
        user.setUserName("dsil" + second + 10);

        userClient.addUser(user);

    }
}
