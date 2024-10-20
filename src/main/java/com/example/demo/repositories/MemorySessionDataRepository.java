package com.example.demo.repositories;


import com.example.demo.model.MemorySessionData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemorySessionDataRepository extends JpaRepository<MemorySessionData, Integer> {

    @Query("SELECT md FROM MemorySessionData  md WHERE md.user.id = ?1")
    List<MemorySessionData> findMemorySessionDataByUserId(int userId);

    @Query("SELECT MAX(my.score), my.user.username " + "FROM MemorySessionData my " + "JOIN my.user u " + "GROUP BY my.user.username")
    List<Object[]> getMemoryMaxScoreWithUsername();
}
