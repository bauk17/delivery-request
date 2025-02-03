package com.caua.deliveryrequest.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.caua.deliveryrequest.domain.User;
import com.caua.deliveryrequest.dto.UserDTO;
import com.caua.deliveryrequest.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {

        List<User> list = userService.findAll();
        List<UserDTO> DtoList = list.stream().map(item -> new UserDTO(item)).collect(Collectors.toList());

        return ResponseEntity.ok().body(DtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable String id) {
        User obj = userService.findUserById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }

    @PostMapping
    public ResponseEntity<Void> createNewUser(@RequestBody UserDTO objDto) {
        User object = userService.fromDTO(objDto);
        object = userService.createNewUser(object);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(object.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);

        return ResponseEntity.noContent().build();
    }
}
