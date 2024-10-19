package com.example.demo.repositories;

import com.example.demo.model.LearningSessionData;
import com.example.demo.model.MemorySessionData;
import com.example.demo.model.MusicalSessionData;
import com.example.demo.model.SessionData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface SessionDataRepository extends JpaRepository<SessionData, Integer> {

    List<SessionData> findByUserId(int userId);

    @Query("SELECT musd FROM MusicalSessionData musd WHERE musd.user.id = ?1")
    List<MusicalSessionData> findMusicalSessionDataByUserId(int userId);

    @Query("SELECT md FROM MemorySessionData  md WHERE md.user.id = ?1")
    List<MemorySessionData> findMemorySessionDataByUserId(int userId);

    @Query("SELECT ld FROM LearningSessionData ld WHERE ld.user.id = ?1")
    List<LearningSessionData> findLearningSessionDataByUserId(int userId);


}
