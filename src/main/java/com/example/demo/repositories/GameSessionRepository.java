package com.example.demo.repositories;

import com.example.demo.model.GameSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface GameSessionRepository extends JpaRepository<GameSession, Integer> {

    @Query("SELECT gs FROM GameSession gs WHERE gs.reflexSessionData IS NOT NULL")
    List<GameSession> findReflexSessions();

    @Query("SELECT gs FROM GameSession gs WHERE gs.memorySessionData IS NOT NULL")
    List<GameSession> findMemorySessions();

    @Query("SELECT gs FROM GameSession gs WHERE gs.learningSessionData IS NOT NULL")
    List<GameSession> findLearningSessions();

}
