package com.example.esd_backend.DAO.DAOImplementation;

import com.example.esd_backend.Bean.Employee;
import com.example.esd_backend.DAO.EmployeeDAO;
import com.example.esd_backend.Util.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public boolean addEmployee(Employee employee){

        try (Session session = SessionUtil.getSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(employee);
            transaction.commit();
            return true;
        }
        catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
            return false;
        }
    }
    @Override
    public Employee login(Employee employee){
        try (Session session = SessionUtil.getSession()){
            String employeeEmail = employee.getEmail();
            String employeePassword = employee.getPassword();
            List<Object> result = new ArrayList<Object>(
                    session.createQuery(
                                    "FROM Employee WHERE email = :employeeEmail AND password = :employeePassword"
                            )
                            .setParameter("employeeEmail", employeeEmail)
                            .setParameter("employeePassword", employeePassword)
                            .list()

            );
            if(result.size()==0)
                return null;
            else {
                Employee emp =  (Employee) result.get(0);
                return emp;
            }
        }
        catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
        }
        return  null;
    }
    @Override
    public List<Employee> getEmployee(){
        try (Session session = SessionUtil.getSession()){
            List<Employee> empList = new ArrayList<>();
            for (final Object d : session.createQuery("from Employee ").list()) {
                empList.add((Employee) d);
            }
            return empList;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }
    @Override
    public Employee getEmployeeByEmail(String email) {

        try (Session session = SessionUtil.getSession()){
            return session.get(Employee.class, email);
        }
        catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
        }
        return  null;
    }
    @Override
    public Employee getEmployeeByID(int employee_id) {
        try (Session session = SessionUtil.getSession()) {
            return session.get(Employee.class, employee_id);
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }
}
