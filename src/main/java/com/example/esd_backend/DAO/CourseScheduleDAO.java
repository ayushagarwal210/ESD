package com.example.esd_backend.DAO;

import com.example.esd_backend.Bean.CourseSchedule;

public interface CourseScheduleDAO {
    boolean addCourseSchedule(CourseSchedule courseSchedule);
    CourseSchedule getCourseScheduleByID(int courseScheduleID);
}
