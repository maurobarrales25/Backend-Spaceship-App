package com.example.demo.dto;

import java.time.LocalDateTime;

public class MusicalSessionDataDTO {

    private int id;
    private int score;
    private int userId;
    private LocalDateTime sessionDate;

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDateTime getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(LocalDateTime sessionDate) {
        this.sessionDate = sessionDate;
    }

    @Override
    public String toString() {
        return "SessionDataDTO{" +
                "id=" + id +
                ", score=" + score +
                ", userId=" + userId +
                ", sessionDate=" + sessionDate +
                '}';
    }
}

