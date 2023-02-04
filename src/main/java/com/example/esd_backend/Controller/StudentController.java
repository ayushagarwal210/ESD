package com.example.esd_backend.Controller;

import com.example.esd_backend.Bean.Student;
import com.example.esd_backend.DAO.DAOImplementation.StudentDAOImpl;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/student")
public class StudentController {
    StudentDAOImpl stuDAO=new StudentDAOImpl();

    @POST
    @Path("/add")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add_student(Student student){
        if(stuDAO.addStudent(student))
            return Response.status(200).entity("Successfully added Student").build();
        return Response.status(400).entity("Failure while adding Student").build();
    }
}
