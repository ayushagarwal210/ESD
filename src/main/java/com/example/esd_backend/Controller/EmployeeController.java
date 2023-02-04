package com.example.esd_backend.Controller;

import com.example.esd_backend.Bean.Department;
import com.example.esd_backend.Bean.Employee;
import com.example.esd_backend.DAO.DAOImplementation.DepartmentDAOImpl;
import com.example.esd_backend.DAO.DAOImplementation.EmployeeDAOImpl;
import com.example.esd_backend.DAO.DepartmentDAO;
import com.example.esd_backend.DAO.EmployeeDAO;
import com.example.esd_backend.HelloApplication;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/faculty")
public class EmployeeController extends HelloApplication {
    EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(Employee employee) {
        Employee employee1 = employeeDAO.login(employee);
        if(employee1 == null)
            return Response.status(401).build();
        else
            return  Response.ok().entity(employee1).build();
    }
    @POST
    @Path("/add")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add_faculty(Employee employee) {

        if(employeeDAO.addEmployee(employee))
            return Response.status(200).entity("Sucessfully added Employee").build();

        else
            return Response.status(400).entity("Failure while adding Employee").build();
    }
    EmployeeDAO empDAO=new EmployeeDAOImpl();
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_employee(){
        List<Employee> emp = empDAO.getEmployee();
        System.out.printf("Hello world");
        return Response.status(200).entity(emp).build();
    }
}
