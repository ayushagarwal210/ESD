package com.example.esd_backend.Bean;

import jakarta.persistence.*;

import java.sql.Time;

@Entity
public class CourseSchedule {
    @Id
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    private Time time;
    private String day;
    private String room;
    private String building;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public CourseSchedule( Time time, String day, String room, String building,Course course) {
//        this.id = id;
        this.course = course;
        this.time = time;
        this.day = day;
        this.room = room;
        this.building = building;
    }

    public CourseSchedule() {
    }
}
