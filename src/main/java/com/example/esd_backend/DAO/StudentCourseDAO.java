package com.example.esd_backend.DAO;

import com.example.esd_backend.Bean.StudentCourse;

public interface StudentCourseDAO {
    boolean addStudentCourse(StudentCourse studentCourse);
    StudentCourse getStudentCourseByID(int studentCourseID);
}
