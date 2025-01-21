package com.caua.deliveryrequest.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caua.deliveryrequest.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User caua = new User("cauapereira_@hotmail.com", "1", "Cauã");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(caua));
        return ResponseEntity.ok().body(list);
    }
}
