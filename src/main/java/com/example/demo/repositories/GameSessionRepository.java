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

    @Query("SELECT gs FROM GameSession  gs WHERE gs.user.id = ?1")
    List<GameSession> findByUserId(int userId);

    @Query("SELECT gs FROM GameSession gs WHERE gs.user.id = ?1 AND gs.reflexSessionData IS NOT NULL")
    List<GameSession> findReflexSessionsByUserId(int userId);

    @Query("SELECT gs FROM GameSession gs WHERE gs.user.id = ?1 AND gs.memorySessionData IS NOT NULL")
    List<GameSession> findMemorySessionsByUserId(int userId);

    @Query("SELECT gs FROM GameSession gs WHERE gs.user.id = ?1 AND gs.learningSessionData IS NOT NULL")
    List<GameSession> findLearningSessionsByUserId(int userId);

}
