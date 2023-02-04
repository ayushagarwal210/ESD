package com.example.esd_backend.DAO.DAOImplementation;

import com.example.esd_backend.Bean.Specialization;
import com.example.esd_backend.DAO.SpecializationDAO;
import com.example.esd_backend.Util.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SpecializationDAOImpl implements SpecializationDAO {
    @Override
    public boolean addSpecialization(Specialization specialization) {
        try(Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(specialization);
            transaction.commit();
            return true;
        }
        catch (HibernateException e){
            System.out.println(e.getLocalizedMessage());
            return false;
        }
    }
    @Override
    public Specialization getSpecializationByID(int specializationID) {

        try (Session session = SessionUtil.getSession()){
            return session.get(Specialization.class, specializationID);
        }
        catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
        }
        return  null;
    }
}
