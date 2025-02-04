package com.caua.deliveryrequest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caua.deliveryrequest.domain.User;
import com.caua.deliveryrequest.dto.UserDTO;
import com.caua.deliveryrequest.repository.UserRepository;
import com.caua.deliveryrequest.services.exception.ObjectNotFoundException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Object not found! ID: " + id));

    }

    public User createNewUser(User obj) {
        return userRepository.insert(obj);
    }

    public void deleteUser(String id) {
        findUserById(id);
        userRepository.deleteById(id);
    }

    public User updateUser(User object) {
        User newObject = findUserById(object.getId());
        newObject.setEmail(object.getEmail());
        newObject.setName(object.getName());
        return userRepository.save(newObject);
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getEmail(), objDto.getId(), objDto.getName());
    }
}
