package com.example.esd_backend.Controller;

import com.example.esd_backend.Bean.Department;
import com.example.esd_backend.Bean.Employee;
import com.example.esd_backend.DAO.DAOImplementation.DepartmentDAOImpl;
import com.example.esd_backend.DAO.DAOImplementation.EmployeeDAOImpl;
import com.example.esd_backend.DAO.DepartmentDAO;
import com.example.esd_backend.DAO.EmployeeDAO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/department")
public class DepartmentController {
    DepartmentDAO deptDAO=new DepartmentDAOImpl();
    @POST
    @Path("/add")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add_faculty(Department department) {

        if(deptDAO.addDepartment(department))
            return Response.status(200).entity("Sucessfully added Department").build();

        else
            return Response.status(400).entity("Failure while adding Department").build();
    }
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_department(){
        List<Department> dept = deptDAO.getDepartment();
        System.out.printf("Hello world");
        return Response.status(200).entity(dept).build();
    }

}
