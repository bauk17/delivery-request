package com.caua.deliveryrequest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.caua.deliveryrequest.domain.User;
import com.caua.deliveryrequest.repository.UserRepository;

@Configuration
public class Instance implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Server successfully inicializated!");

        userRepository.deleteAll();

        User config = new User("testingconnection_@hotmail.com", null, "Testing Instance");

        userRepository.save(config);
    }

}
