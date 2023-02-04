package com.example.esd_backend.DAO;

import com.example.esd_backend.Bean.Specialization;

public interface SpecializationDAO {
    boolean addSpecialization(Specialization specialization);
    Specialization getSpecializationByID(int specializationID);
}
