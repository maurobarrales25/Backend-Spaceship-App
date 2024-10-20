package com.example.demo.repositories;


import com.example.demo.dto.MaxScoreDTO;
import com.example.demo.model.MusicalSessionData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MusicalSessionDataRepository extends JpaRepository<MusicalSessionData, Integer> {

    @Query("SELECT musd FROM MusicalSessionData musd WHERE musd.user.id = ?1")
    List<MusicalSessionData> findMusicalSessionDataByUserId(int userId);

    @Query("SELECT MAX(ms.score), ms.user.username " + "FROM MusicalSessionData ms " + "JOIN ms.user u " + "GROUP BY ms.user.username")
    List<Object[]> getMusicalMaxScoreWithUsername();

}
