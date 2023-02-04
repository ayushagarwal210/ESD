package com.example.esd_backend.service;

import com.example.esd_backend.Bean.Course;
import com.example.esd_backend.Bean.CourseSchedule;
import com.example.esd_backend.Bean.Specialization;
import com.example.esd_backend.DAO.DAOImplementation.CourseScheduleDAOImpl;
import com.example.esd_backend.DAO.DAOImplementation.EmployeeDAOImpl;
import com.example.esd_backend.DAO.DAOImplementation.SpecializationDAOImpl;
import com.example.esd_backend.DAO.SpecializationDAO;

import java.util.List;

public class CourseService {
    EmployeeDAOImpl employeeDAO=new EmployeeDAOImpl();
    SpecializationDAO specializationDAO=new SpecializationDAOImpl();
    CourseScheduleDAOImpl courseScheduleDAO=new CourseScheduleDAOImpl();

    public List<Course> getCourseByFaculty(int facultyID){
        return employeeDAO.getEmployeeByID(facultyID).getCourses();
    }
    public void get_all(int facultyID) {

        List<Course>Courses = getCourseByFaculty(facultyID);
        for(Course course: Courses){
            List<CourseSchedule> courseSchedules = course.getCourseSchedule();
            List<Specialization> specializationList = course.getSpecializationList();
        }
    }
}
