package com.example.esd_backend.Controller;

import com.example.esd_backend.Bean.Course;
import com.example.esd_backend.DAO.DAOImplementation.CourseDAOImpl;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/course")
public class CourseController {

    CourseDAOImpl courseDAO = new CourseDAOImpl();
    @POST
    @Path("/add")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add_course(Course course) {

        if(courseDAO.addCourse(course))
            return Response.status(200).entity("Successfully added Course").build();

        else
            return Response.status(400).entity("Failure while adding Course").build();
    }
}
