package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.ElementCollection;

import java.util.List;

@Entity
@Table(name = "reflex_session_data")
public class ReflexSessionData extends SessionData {

    @ElementCollection
    private List<Double> times ;

    public List<Double> getTimes() {
        return times;
    }

    public void setTimes(List<Double> times) {
        this.times = times;
    }

    @Override
    public String toString() {
        return "ReflexSessionData{" +
                "id=" + getId() +
                ", score=" + getScore() +
                ", user=" + getUser() +
                ", sessionDate=" + getSessionDate() +
                ", times=" + times +
                '}';
    }

}
