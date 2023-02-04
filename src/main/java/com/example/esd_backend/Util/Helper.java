package com.example.esd_backend.Util;

import com.example.esd_backend.Bean.*;
import com.example.esd_backend.DAO.CourseDAO;
import com.example.esd_backend.DAO.DAOImplementation.*;
import com.example.esd_backend.DAO.SpecializationDAO;
import com.example.esd_backend.service.CourseService;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Helper {
    public static void main(String[] args) {
        PopulateDepartment();
        PopulateEmployee();
        PopulateCourse();
        PopulateSpecialization();
        PopulateCourseSchedule();
        PopulateStudent();
        PopulateStudentCourse();
    }
//    public static void populateDummyData(){
//        PopulateDepartment();
//        PopulateEmployee();
//        PopulateCourse();
//        PopulateSpecialization();
//        PopulateCourseSchedule();
//        PopulateStudent();
//        PopulateStudentCourse();
//    }

    public static void temp() {
        CourseService courseService =  new CourseService();
        courseService.getCourseByFaculty(1);
    }

    public static void PopulateDepartment() {
        Department d1 = new Department("Faculty",200);
        Department d2 = new Department("Research",100);
        DepartmentDAOImpl departmentDAO = new DepartmentDAOImpl();
        departmentDAO.addDepartment(d1);
        departmentDAO.addDepartment(d2);
    }

    public static void PopulateEmployee(){
        DepartmentDAOImpl departmentDAO =new DepartmentDAOImpl();
        Department d1 = departmentDAO.getDepartmentByID(1);
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();

        Employee e1 = new Employee("Jyotsna", "Bapat","nike" ,"jyotsna.bapat@iiitb.org", "Prof",null, d1,null);
        Employee e2 = new Employee("Muralidhara", "VN", "nike","muralidhara.vn@iiitb.org", "Prof", null,d1,null);
        Employee e3 = new Employee("Thangaraju", "B", "bike","thangaraju.b@iiitb.org", "Prof",null, d1,null);
        Employee e4 = new Employee("Ramasubramanian", "V", "bike","ramasubramanian.v@iiitb.org", "Prof",null, d1,null);
        Employee e5 = new Employee("Xman", "V", "bike","xman@gmail.com", "Prof",null, d1,null);
        employeeDAO.addEmployee(e1);
        employeeDAO.addEmployee(e2);
        employeeDAO.addEmployee(e3);
        employeeDAO.addEmployee(e4);
        employeeDAO.addEmployee(e5);
    }

    public  static void PopulateCourse() {
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        Employee faculty1 = employeeDAO.getEmployeeByID(1);
        Employee faculty2 = employeeDAO.getEmployeeByID(2);
        Employee faculty3 = employeeDAO.getEmployeeByID(3);
        Employee faculty4 = employeeDAO.getEmployeeByID(5);
        Course c1 = new Course("CS511","Algorithms","2022","1",4,200,"Algorithms",faculty2,null,null);
        Course c2 = new Course("CS513","Software System","2022","1",4,200,"Software System",faculty3,null,null);
        Course c3 = new Course("AI511","Machine Learning","2022","1",4,200,"Machine Learning",faculty1,null,null);
        Course c4 = new Course("AI501","Foundation of AI","2022","1",4,200,"Foundation of AI",faculty4,null,null);
        CourseDAOImpl courseDAO = new CourseDAOImpl();
        courseDAO.addCourse(c1);
        courseDAO.addCourse(c2);
        courseDAO.addCourse(c3);
        courseDAO.addCourse(c4);
    }
    public static void PopulateSpecialization() {

        CourseDAO courseDAO = new CourseDAOImpl();
        Course c1 = courseDAO.getCourseBYID(1);
        Course c2 = courseDAO.getCourseBYID(2);
        Course c4 = courseDAO.getCourseBYID(4);
        Course c3 = courseDAO.getCourseBYID(3);

        List<Course> courseList1 = new ArrayList<>();
        courseList1.add(c1);
        courseList1.add(c2);
        List<Course>courseList2 = new ArrayList<>();
        courseList2.add(c3);
        courseList2.add(c4);

        Specialization s1 = new Specialization("AI", "Artificial Intelligence",2022,20,"Machine Learning & Data Science",courseList1);
        Specialization s2 = new Specialization("CS", "Computer Science",2022,24,"Theory of Computer Science & Design",courseList2);

        SpecializationDAO specializationDAO = new SpecializationDAOImpl();
        specializationDAO.addSpecialization(s1);
        specializationDAO.addSpecialization(s2);
    }

    public static void PopulateCourseSchedule() {
        CourseDAOImpl courseDAO = new CourseDAOImpl();
        Course c1 = courseDAO.getCourseBYID(1);
        Course c2 = courseDAO.getCourseBYID(2);
        Course c3 = courseDAO.getCourseBYID(3);
        CourseSchedule courseSchedule1 = new CourseSchedule(Time.valueOf("09:00:00"),"Mon","101","Aryabhatta",c1);
        CourseSchedule courseSchedule2 = new CourseSchedule(Time.valueOf("11:00:00"),"Mon","101","Aryabhatta",c2);
        CourseSchedule courseSchedule3 = new CourseSchedule(Time.valueOf("14:00:00"),"Mon","101","Ramanujan",c3);
        CourseScheduleDAOImpl courseScheduleDAO = new CourseScheduleDAOImpl();
        courseScheduleDAO.addCourseSchedule(courseSchedule1);
        courseScheduleDAO.addCourseSchedule(courseSchedule2);
        courseScheduleDAO.addCourseSchedule(courseSchedule3);
    }

    public static void PopulateStudent(){
        SpecializationDAOImpl specializationDAO = new SpecializationDAOImpl();
        Specialization s1 = specializationDAO.getSpecializationByID(8);
        Specialization s2 = specializationDAO.getSpecializationByID(9);

        Student stu1 = new Student("akshat","karodiya","MT2022011","akshat.karodiya@iiitb.ac.in",null,0,24,2024,s1);
        Student stu2 = new Student("akshay","","MT2022001","akshay@iiitb.ac.in",null,0,24,2024,s1);
        Student stu3 = new Student("ayush","agarwal","MT2022027","ayush@iiitb.ac.in",null,0,24,2024,s2);
        Student stu4 = new Student("aryan","","MT2022003","aryan@iiitb.ac.in",null,0,24,2024,s1);
        Student stu5 = new Student("yash","","MT2022004","yash@iiitb.ac.in",null,0,24,2024,s1);

        StudentDAOImpl studentDAO = new StudentDAOImpl();
        studentDAO.addStudent(stu1);
        studentDAO.addStudent(stu2);
        studentDAO.addStudent(stu3);
        studentDAO.addStudent(stu4);

    }

    public static void PopulateStudentCourse() {
        CourseDAOImpl courseDAO = new CourseDAOImpl();

        Course c1 = courseDAO.getCourseBYID(1);
        Course c2 = courseDAO.getCourseBYID(2);
        Course c3 = courseDAO.getCourseBYID(3);
        Course c4 = courseDAO.getCourseBYID(4);

        StudentDAOImpl studentDAO = new StudentDAOImpl();
        Student s1 = studentDAO.getStudentByID(6);
        Student s2 = studentDAO.getStudentByID(7);
        Student s3 = studentDAO.getStudentByID(8);
        Student s5 = studentDAO.getStudentByID(5);

        StudentCourse sc1  =  new StudentCourse(s1,c1,"course 1");
        StudentCourse sc2  =  new StudentCourse(s1,c2,"course 2");
        StudentCourse sc3  =  new StudentCourse(s2,c1,"course 1");
        StudentCourse sc4  =  new StudentCourse(s2,c3,"course 3");
        StudentCourse sc5  =  new StudentCourse(s3,c4,"course 4");
        StudentCourse sc7  =  new StudentCourse(s5,c1,"course 1");

        StudentCourseDAOImpl studentCourseDAO = new StudentCourseDAOImpl();

        studentCourseDAO.addStudentCourse(sc1);
        studentCourseDAO.addStudentCourse(sc2);
        studentCourseDAO.addStudentCourse(sc3);
        studentCourseDAO.addStudentCourse(sc4);
        studentCourseDAO.addStudentCourse(sc5);
        studentCourseDAO.addStudentCourse(sc7);




    }

}
