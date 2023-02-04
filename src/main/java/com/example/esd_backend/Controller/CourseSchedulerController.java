package com.example.esd_backend.Controller;

import com.example.esd_backend.Bean.CourseSchedule;
import com.example.esd_backend.DAO.DAOImplementation.CourseScheduleDAOImpl;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/courseschedule")
public class CourseSchedulerController {
    CourseScheduleDAOImpl courseScheduleDAO = new CourseScheduleDAOImpl();

    @POST
    @Path("/add")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add_faculty(CourseSchedule courseSchedule) {

        if(courseScheduleDAO.addCourseSchedule(courseSchedule))
            return Response.status(200).entity("Sucessfully added Department").build();

        else
            return Response.status(400).entity("Failure while adding Department").build();
    }
}
