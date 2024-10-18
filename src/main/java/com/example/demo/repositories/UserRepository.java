package com.example.demo.repositories;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


    @Query("SELECT u From User u WHERE u.username = ?1")
    Optional<User> findUserByUsername(String username);

    Optional<User> findByUsername(String username); // sirve igual

}

