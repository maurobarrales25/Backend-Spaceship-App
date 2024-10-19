package com.example.demo.dto;

import java.time.LocalDateTime;

public class GameSessionDTO {
    private int id;
    private int score;
    private LocalDateTime sessionDate;
    private int userId;

    public GameSessionDTO(int id, int score, LocalDateTime sessionDate, int userId) {
        this.id = id;
        this.score = score;
        this.sessionDate = sessionDate;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "GameSessionDTO{" +
                "id=" + id +
                ", score=" + score +
                ", sessionDate=" + sessionDate +
                ", userId=" + userId +
                '}';
    }
}
