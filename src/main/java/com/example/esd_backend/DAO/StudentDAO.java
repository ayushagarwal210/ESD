package com.example.esd_backend.DAO;

import com.example.esd_backend.Bean.Student;

import java.util.List;

public interface StudentDAO {
    Student getStudentByID (int student_id);
    List<Student> getStudent();
    boolean addStudent(Student student);
}
