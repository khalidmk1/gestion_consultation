package com.consultation.gestion_consultation.service;

import com.consultation.gestion_consultation.entities.Consultation;
import com.consultation.gestion_consultation.entities.Patient;

import java.sql.SQLException;
import java.util.List;

public interface IConsulteService {
    void addPatient(Patient patient);
    void updatePatient(Patient patient);
    void deletePatient(Patient patient);
    List<Patient> getALLPatients();
    Patient getPatientById(Long id);
    List<Patient> searchPatientQuery(String query) throws SQLException;

    void addConsultation(Consultation consultation);
    void updateConsultation(Consultation consultation);
    void deleteConsultation(Consultation consultation);
    List<Consultation> getALLConsultations();
    Consultation getConsultationById(Long id);

}
