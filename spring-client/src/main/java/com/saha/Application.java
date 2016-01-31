package com.saha;

import com.saha.clients.BilyonerClient;
import com.saha.clients.UserClient;
import com.saha.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;

@SpringBootApplication
@EnableScheduling
public class Application{


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);



	}

	@Autowired
	private UserClient userClient;

	@Autowired
	private BilyonerClient bilyonerClient;

//	@Override
	public void run(String... strings) throws Exception {
		bilyonerClient.gitLabClient();
		bilyonerClient.liveScores();


		System.out.println("strings = " + strings);
		User user = userClient.user(11L);
		System.out.println("user = " + user);
		user = userClient.user(15L);
		System.out.println("user = " + user);

		List<User> users = userClient.users();

		for (User user1 : users) {
			System.out.println("user1 = " + user1);
		}

		User newUser = new User();
		newUser.setLastName("yeniKulllacini");
		newUser.setName("Yeni isim");
		newUser.setUserName("sonKULlanici");
		userClient.addUser(newUser);


		System.out.println(" ===========  ");
		users = userClient.users();
		for (User user1 : users) {
			System.out.println("user1 = " + user1);
		}

	//	userClient.deleteUser(22L);
	//	System.out.println("user = " + user);


	}
}
