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

    @Query("SELECT COUNT(r) FROM ReflexSessionData r WHERE r.user.id = ?1")
    int countByUserId(int userId);

    @Query("SELECT MAX(r.score) FROM ReflexSessionData r")
    Integer findBestScore();

    @Query("SELECT MAX(r.score) FROM ReflexSessionData r WHERE r.user.id = ?1")
    Integer findBestScoreByUserId(int userId);

    @Query("SELECT MAX(r.score), r.user.username " + "FROM ReflexSessionData r " + "JOIN r.user u " + "GROUP BY r.user.username")
    List<Object[]> getReflexMaxScoresWithUsernames();
}
