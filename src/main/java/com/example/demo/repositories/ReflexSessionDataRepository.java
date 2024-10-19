package com.example.demo.repositories;

import com.example.demo.model.ReflexSessionData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReflexSessionDataRepository extends JpaRepository<ReflexSessionData, Integer> {

    @Query("SELECT r FROM ReflexSessionData  r WHERE r.user.id = ?1")
    List<ReflexSessionData> findReflexSessionsByUserId(int userId);
}
