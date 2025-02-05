package com.caua.deliveryrequest.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.caua.deliveryrequest.domain.Post;
import com.caua.deliveryrequest.domain.User;
import com.caua.deliveryrequest.repository.PostRepository;
import com.caua.deliveryrequest.repository.UserRepository;

@Configuration
public class Instance implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Server successfully inicializated!");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User config = new User("testingconnection_@hotmail.com", null, "Testing Instance");
        User secondConfig = new User("testingsecondconnection_@hotmail.com", null, "Testing Instance");
        User thirdConfig = new User("testingthirdconnection@hotmail.com", null, "Testing Instance");

        Post firstPost = new Post(null, sdf.parse("05/02/2025"), "Olá", "Testando post", config);
        userRepository.saveAll(Arrays.asList(config, secondConfig, thirdConfig));
        postRepository.save(firstPost);
    }

}
