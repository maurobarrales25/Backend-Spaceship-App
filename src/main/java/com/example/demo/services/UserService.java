package com.example.demo.services;

import com.example.demo.dto.UserDTO;
import com.example.demo.mappers.UserMapper;
import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {


    private final UserRepository userRepository;
    private final UserMapper userMapper = UserMapper.INSTANCE;

    public UserDTO getUserById(int id) {
        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("Usuario no encontrado"));
        return userMapper.usernameToUserDto(user);
    }

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(userMapper::userToUserDto).collect(Collectors.toList());
       // return userRepository.findAll();
//        List<User> list1 = List.of(
//                new User(
//                        1,
//                        "Mark Watson",
//                        "MWatson",
//                        "markwatson@example.com",
//                        passwordEncoder.encode("password123")
//                )
//        );
//        List<UserDTO> list2 = new ArrayList<UserDTO>();

//        return list2;



    }

    public UserDTO createUser(User user) {
        Optional<User> userUsername = userRepository.findUserByUsername(user.getUsername());
        if (userUsername.isPresent()) {
            throw new IllegalStateException("Ese username ya se existe.");
        }
        User savedUser = userRepository.save(user); // Guarda el usuario en la base de datos
        return userMapper.userToUserDto(savedUser); // Mapea y devuelve el UserDTO
    }

    public boolean checkPassword(User user, String rawPassword) {
        return user.getPassword().equals(rawPassword);
    }

    public void deleteUser(Integer userId){
        boolean exists = userRepository.existsById(userId);
        if (!exists){
            throw new IllegalStateException("User with id "+ userId + "doesnt exist");
        }
        userRepository.deleteById(userId);
    }

    public Optional<User> findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }


}

//De controller a service todo userDTO . De Service para abajo por user.