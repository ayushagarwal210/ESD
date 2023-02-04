package com.example.esd_backend.DAO;

import com.example.esd_backend.Bean.Course;

public interface CourseDAO {
    boolean addCourse(Course course);
    Course getCourseBYID(int courseID);
}
