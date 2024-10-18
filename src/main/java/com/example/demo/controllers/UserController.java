package com.example.demo.controllers;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<UserDTO> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody User user) {
        UserDTO createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

}
