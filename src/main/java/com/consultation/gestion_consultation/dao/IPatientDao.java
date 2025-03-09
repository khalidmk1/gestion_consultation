package com.consultation.gestion_consultation.dao;

import com.consultation.gestion_consultation.entities.Patient;

import java.sql.SQLException;
import java.util.List;

public interface IPatientDao extends Dao<Patient,Long>{

    List<Patient> searchPatientByQuery(String query) throws SQLException;

}
