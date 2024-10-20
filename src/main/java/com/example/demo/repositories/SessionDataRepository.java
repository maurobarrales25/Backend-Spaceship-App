package com.example.demo.repositories;


import com.example.demo.model.MusicalSessionData;
import com.example.demo.model.SessionData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface SessionDataRepository extends JpaRepository<SessionData, Integer> {

    List<SessionData> findByUserId(int userId);

    @Query("SELECT musd FROM MusicalSessionData musd WHERE musd.user.id = ?1")
    List<MusicalSessionData> findMusicalSessionDataByUserId(int userId);






}
