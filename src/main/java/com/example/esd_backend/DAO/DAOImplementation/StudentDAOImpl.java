package com.example.esd_backend.DAO.DAOImplementation;

import com.example.esd_backend.Bean.Student;
import com.example.esd_backend.DAO.StudentDAO;
import com.example.esd_backend.Util.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public List<Student> getStudent(){
        try (Session session = SessionUtil.getSession()){
            List<Student> empList = new ArrayList<>();
            for (final Object d : session.createQuery("from Student ").list()) {
                empList.add((Student) d);
            }
            return empList;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public Student getStudentByID(int student_id) {
        try (Session session = SessionUtil.getSession()) {
            return session.get(Student.class, student_id);
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }
    @Override
    public boolean addStudent(Student student) {
        try (Session session = SessionUtil.getSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(student);
            transaction.commit();
            return true;
        }
        catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
            return false;
        }
    }


}
