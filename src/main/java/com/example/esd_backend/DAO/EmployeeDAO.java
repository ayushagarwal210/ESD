package com.example.esd_backend.DAO;

import com.example.esd_backend.Bean.Employee;

import java.util.List;

public interface EmployeeDAO {
    boolean addEmployee(Employee employee);
    Employee login (Employee employee);
    Employee getEmployeeByID (int employee_id);
    Employee getEmployeeByEmail (String email);
    List<Employee> getEmployee();
}
