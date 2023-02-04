package com.example.esd_backend.DAO.DAOImplementation;
import com.example.esd_backend.Bean.Department;
import com.example.esd_backend.Bean.Employee;
import com.example.esd_backend.DAO.DepartmentDAO;
import com.example.esd_backend.Util.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {
    @Override
    public boolean addDepartment(Department department) {

        try (Session session = SessionUtil.getSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(department);
            transaction.commit();
            return true;
        }
        catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
            return false;
        }
    }
    @Override
    public Department getDepartmentByID(int departmentID){
        try (Session session = SessionUtil.getSession()){
            return session.get(Department.class, departmentID);
        }
        catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
        }
        return  null;
    }
    @Override
    public List<Department> getDepartment(){
        try (Session session = SessionUtil.getSession()){
            List<Department> deptList = new ArrayList<>();
            for (final Object d : session.createQuery("from Department ").list()) {
                deptList.add((Department) d);
            }
            return deptList;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }
}
