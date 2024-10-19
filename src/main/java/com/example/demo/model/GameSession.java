package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "game_session")
public class GameSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name ="user_id", nullable = false)
    private User user;


    @Column
    private int score;

    @Column(name="session_Date", columnDefinition = "TIMESTAMP DEFUALT CURRENT_TIMESTAMP")
    private LocalDateTime sessionDate;

    @OneToOne
    private ReflexSessionData  reflexSessionData;

    @OneToOne
    private MemorySessionData memorySessionData;

    @OneToOne
    private LearningSessionData learningSessionData;

    public GameSession(LocalDateTime sessionDate, int score, User user, int id) {
        this.sessionDate = sessionDate;
        this.score = score;
        this.user = user;
        this.id = id;
    }

    public GameSession() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public LocalDateTime getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(LocalDateTime sessionDate) {
        this.sessionDate = sessionDate;
    }

    public ReflexSessionData getReflexSessionData() {
        return reflexSessionData;
    }

    public void setReflexSessionData(ReflexSessionData reflexSessionData) {
        this.reflexSessionData = reflexSessionData;
    }

    public MemorySessionData getMemorySessionData() {
        return memorySessionData;
    }

    public void setMemorySessionData(MemorySessionData memorySessionData) {
        this.memorySessionData = memorySessionData;
    }

    public LearningSessionData getLearningSessionData() {
        return learningSessionData;
    }

    public void setLearningSessionData(LearningSessionData learningSessionData) {
        this.learningSessionData = learningSessionData;
    }
}
