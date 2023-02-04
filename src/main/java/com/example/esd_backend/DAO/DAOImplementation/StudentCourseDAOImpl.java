package com.example.esd_backend.DAO.DAOImplementation;

import com.example.esd_backend.Bean.StudentCourse;
import com.example.esd_backend.DAO.StudentCourseDAO;
import com.example.esd_backend.Util.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentCourseDAOImpl implements StudentCourseDAO {
    @Override
    public boolean addStudentCourse(StudentCourse studentCourse) {
        try (Session session = SessionUtil.getSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(studentCourse);
            transaction.commit();
            return true;
        }
        catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public StudentCourse getStudentCourseByID(int studentCourseID) {

        try (Session session = SessionUtil.getSession()){
            return session.get(StudentCourse.class, studentCourseID);
        }
        catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
        }
        return  null;
    }
}
