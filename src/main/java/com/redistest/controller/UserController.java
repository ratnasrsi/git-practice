package com.redistest.controller;

import com.redistest.model.User;
import com.redistest.repository.UserRepository;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @GetMapping
    public List<User> getAllUsers(){
        log.info("retrieveing all users from DB");
        return userRepository.findAll();
    }
    @PostMapping
    public User saveUser(@RequestBody User user){
       return userRepository.save(user);
    }


}

