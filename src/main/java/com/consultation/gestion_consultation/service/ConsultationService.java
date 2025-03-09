package com.consultation.gestion_consultation.service;

import com.consultation.gestion_consultation.dao.IConsultationDao;
import com.consultation.gestion_consultation.dao.IPatientDao;
import com.consultation.gestion_consultation.entities.Consultation;
import com.consultation.gestion_consultation.entities.Patient;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultationService implements IConsulteService{

    private IPatientDao ipatientDao;
    private IConsultationDao iconsultationDao;

    public ConsultationService(IPatientDao ipatientDao, IConsultationDao iconsultationDao) {
        this.ipatientDao = ipatientDao;
        this.iconsultationDao = iconsultationDao;
    }

    @Override
    public void addPatient(Patient patient) {
        try {
            ipatientDao.create(patient);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updatePatient(Patient patient) {
        try {
            ipatientDao.update(patient);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePatient(Patient patient) {
        try {
            ipatientDao.delete(patient);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Patient> getALLPatients() {
       List<Patient> patients = null ;
        try {
            patients = ipatientDao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }

    @Override
    public Patient getPatientById(Long id) {
       Patient patient = null;
       try {
           patient = ipatientDao.findById(id);
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return patient;
    }

    @Override
    public List<Patient> searchPatientQuery(String query) throws SQLException {
       return ipatientDao.searchPatientByQuery(query);
    }


    @Override
    public void addConsultation(Consultation consultation) {
        try {
            iconsultationDao.create(consultation);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateConsultation(Consultation consultation) {
        try {
            iconsultationDao.update(consultation);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteConsultation(Consultation consultation) {
        try {
            iconsultationDao.delete(consultation);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Consultation> getALLConsultations() {
        List<Consultation> consultations = null;
        try {
            consultations = iconsultationDao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consultations;
    }

    @Override
    public Consultation getConsultationById(Long id) {
        Consultation consultation = null;
        try {
             consultation = iconsultationDao.findById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consultation;
    }
}
