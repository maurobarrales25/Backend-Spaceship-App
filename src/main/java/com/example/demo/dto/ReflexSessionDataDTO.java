package com.example.demo.dto;


import java.time.LocalDateTime;
import java.util.List;

public class ReflexSessionDataDTO {

    private int id;
    private int score;
    private int userId;
    private LocalDateTime sessionDate;
    private List<Double> times;

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

    public List<Double> getTimes() {
        return times;
    }

    public void setTimes(List<Double> times) {
        this.times = times;
    }

    @Override
    public String toString() {
        return "ReflexSessionDataDTO{" +
                "id=" + getId() +
                ", score=" + getScore() +
                ", userId=" + getUserId() +
                ", sessionDate=" + getSessionDate() +
                ", times=" + times +
                '}';
    }
}
