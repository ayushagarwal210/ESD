package com.example.esd_backend.DAO;

import com.example.esd_backend.Bean.Department;
import com.example.esd_backend.Bean.Employee;

import java.util.List;

public interface DepartmentDAO {
    boolean addDepartment(Department department);
    Department getDepartmentByID(int departmentID);
    List<Department> getDepartment();
}
