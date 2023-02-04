package com.example.esd_backend.Bean;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Course {
    @Id
    @Column(name = "course_id")
    private int courseId;
    @Column(name = "course_code")
    private String courseCode;
    private String name;
    private String term;
    private String year;
    private float credits;
    private int capacity;
    private String description;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Employee employee;

    @OneToMany(mappedBy = "course_id")
    private List<CourseSchedule> courseSchedule;

    @ManyToMany(mappedBy = "course_id")
    private List<Specialization>specializationList;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public float getCredits() {
        return credits;
    }

    public void setCredits(float credits) {
        this.credits = credits;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<CourseSchedule> getCourseSchedule() {
        return courseSchedule;
    }

    public void setCourseSchedule(List<CourseSchedule> courseSchedule) {
        this.courseSchedule = courseSchedule;
    }

    public List<Specialization> getSpecializationList() {
        return specializationList;
    }

    public void setSpecializationList(List<Specialization> specializationList) {
        this.specializationList = specializationList;
    }

    public Course(String courseCode, String name, String year,String term,  float credits, int capacity, String description, Employee employee, List<CourseSchedule> courseSchedule, List<Specialization> specializationList) {
//        this.courseId = courseId;
        this.courseCode = courseCode;
        this.name = name;
        this.term = term;
        this.year = year;
        this.credits = credits;
        this.capacity = capacity;
        this.description = description;
        this.employee = employee;
        this.courseSchedule = courseSchedule;
        this.specializationList = specializationList;
    }

    public Course() {
    }
}
