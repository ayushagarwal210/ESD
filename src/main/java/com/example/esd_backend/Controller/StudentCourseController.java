package com.example.esd_backend.Controller;

import com.example.esd_backend.Bean.StudentCourse;
import com.example.esd_backend.DAO.DAOImplementation.StudentCourseDAOImpl;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/studentcourse")
public class StudentCourseController {
    StudentCourseDAOImpl studentCourseDAO = new StudentCourseDAOImpl();


    @POST
    @Path("/add")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add_faculty(StudentCourse studentCourse) {

        if(studentCourseDAO.addStudentCourse(studentCourse))
            return Response.status(200).entity("Sucessfully added StudentCourse").build();

        else
            return Response.status(400).entity("Failure while adding StudentCourse").build();
    }
}
