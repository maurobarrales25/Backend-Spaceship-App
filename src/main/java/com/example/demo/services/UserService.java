package com.example.demo.services;

import com.example.demo.dto.UserDTO;
import com.example.demo.mappers.UserMapper;
import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private UserMapper userMapper = UserMapper.INSTANCE;

    public UserDTO getUserById(int id) {
        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
        return userMapper.usernameToUserDto(user);
    }


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            return Collections.emptyList();
        }
        return users.stream().map(userMapper::userToUserDto).toList();
    }

    public UserDTO createUser(UserDTO userDTO) {

        User user = userMapper.userDtoToUser(userDTO);

        Optional<User> userUsername = userRepository.findUserByUsername(user.getUsername());
        if (userUsername.isPresent()) {
            throw new IllegalStateException("That username is not available.");
        }
        User savedUser = userRepository.save(user);
        return userMapper.userToUserDto(savedUser);
    }

    public boolean checkPassword(User user, String rawPassword) {
        return user.getPassword().equals(rawPassword);
    }

    public void deleteUser(Integer userId){
        boolean exists = userRepository.existsById(userId);
        if (!exists){
            throw new IllegalStateException("User with id "+ userId + "doesn't exist");
        }
        userRepository.deleteById(userId);
    }

    public Optional<User> findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }


}

//De controller a service todo userDTO . De Service para abajo por user.