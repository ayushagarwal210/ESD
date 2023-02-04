package com.example.esd_backend.DAO.DAOImplementation;

import com.example.esd_backend.Bean.Course;
import com.example.esd_backend.DAO.CourseDAO;
import com.example.esd_backend.Util.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CourseDAOImpl implements CourseDAO {
    @Override
    public boolean addCourse(Course course) {
        try (Session session = SessionUtil.getSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(course);
            transaction.commit();
            return true;
        }
        catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public Course getCourseBYID(int courseID) {

        try (Session session = SessionUtil.getSession()){
            return session.get(Course.class, courseID);
        }
        catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
        }
        return  null;
    }
}
