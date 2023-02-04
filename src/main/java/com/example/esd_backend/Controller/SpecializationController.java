package com.example.esd_backend.Controller;

import com.example.esd_backend.Bean.Specialization;
import com.example.esd_backend.DAO.DAOImplementation.SpecializationDAOImpl;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/specialization")
public class SpecializationController {
    SpecializationDAOImpl specializationDAO=new SpecializationDAOImpl();
    @POST
    @Path("/add")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addSpecialization(Specialization specialization){
        if(specializationDAO.addSpecialization(specialization))
            return Response.status(200).entity("Specialization added successfully").build();
        else
            return Response.status(400).entity("Failed to add Specialization").build();
    }
}
