package com.example.esd_backend.DAO.DAOImplementation;

import com.example.esd_backend.Bean.CourseSchedule;
import com.example.esd_backend.DAO.CourseScheduleDAO;
import com.example.esd_backend.Util.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CourseScheduleDAOImpl implements CourseScheduleDAO {
    @Override
    public boolean addCourseSchedule(CourseSchedule courseSchedule) {
        try (Session session = SessionUtil.getSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(courseSchedule);
            transaction.commit();
            return true;
        }
        catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public CourseSchedule getCourseScheduleByID(int courseScheduleID) {

        try (Session session = SessionUtil.getSession()){
            return session.get(CourseSchedule.class, courseScheduleID);
        }
        catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
        }
        return  null;
    }
}
