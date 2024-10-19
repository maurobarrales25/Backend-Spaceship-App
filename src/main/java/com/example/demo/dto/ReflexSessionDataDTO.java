package com.example.demo.dto;


import java.util.List;

public class ReflexSessionDataDTO extends SessionDataDTO {

    private List<Double> times;

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
