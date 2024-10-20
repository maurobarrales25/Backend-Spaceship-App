package com.example.demo.repositories;

import com.example.demo.dto.MaxScoreDTO;
import com.example.demo.model.LearningSessionData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LearningSessionDataRepository extends JpaRepository<LearningSessionData, Integer> {

    List<LearningSessionData> findByUserId(int userId);

    @Query("SELECT ld FROM LearningSessionData ld WHERE ld.user.id = ?1")
    List<LearningSessionData> findLearningSessionDataByUserId(int userId);

    @Query("SELECT MAX(ld.score), ld.user.username " + "FROM LearningSessionData ld " + "JOIN ld.user u " + "GROUP BY ld.user.username")
    List<Object[]> getLearningMaxScoreWithUsername();


}
