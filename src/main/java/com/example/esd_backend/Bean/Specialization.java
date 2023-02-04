package com.example.esd_backend.Bean;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Specialization {
    @Id
    @Column(name = "specialization_id")
    private int specializationID;
    private String code;
    private String name;
    private String description;
    private int year;
    private int credits_required;

    @ManyToMany(fetch = FetchType.EAGER,targetEntity = Course.class)
    @JoinTable(name = "Specialization_Course",
            joinColumns = { @JoinColumn(name = "specialization_id") },
            inverseJoinColumns = { @JoinColumn(name = "course_id") })
    private List<Course> courseList;

    public int getSpecializationID() {
        return specializationID;
    }

    public void setSpecializationID(int specializationID) {
        this.specializationID = specializationID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCredits_required() {
        return credits_required;
    }

    public void setCredits_required(int credits_required) {
        this.credits_required = credits_required;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public Specialization( String code, String name,  int year, int credits_required, String description,List<Course> courseList) {
//        this.specializationID = specializationID;
        this.code = code;
        this.name = name;
        this.description = description;
        this.year = year;
        this.credits_required = credits_required;
        this.courseList = courseList;
    }

    public Specialization() {
    }
}
