package com.nguvel.progwebapi.controllers;

import com.nguvel.progwebapi.exceptions.RessourceNotFoundException;
import com.nguvel.progwebapi.models.User;
import com.nguvel.progwebapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @CrossOrigin
    @PostMapping("/user")
    public User createUser(@Valid @RequestBody User user){
        User user1 = userRepository.save(user);
        return user1;
    }

    @CrossOrigin
    @GetMapping("/user")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/user/{user_id}")
    public User getById(@PathVariable Long user_id){
        User user = userRepository.getOne(user_id);
        return user;
    }

    @CrossOrigin
    @DeleteMapping("/user")
    public ResponseEntity<?> deleteUser(@PathVariable Long user_id){
        return userRepository.findById(user_id)
                .map(user -> {
                    userRepository.delete(user);
                    return ResponseEntity.ok().build();
                }).orElseThrow(()-> new RessourceNotFoundException("User not found with id " + user_id));
    }
}
