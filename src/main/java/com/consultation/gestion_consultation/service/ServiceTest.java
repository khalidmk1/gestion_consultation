package com.consultation.gestion_consultation.service;

import com.consultation.gestion_consultation.dao.ConsultationDao;
import com.consultation.gestion_consultation.dao.PatientDao;
import com.consultation.gestion_consultation.entities.Patient;

public class ServiceTest {
    public static void main(String[] args) {
        IConsulteService service = new ConsultationService(new PatientDao() , new ConsultationDao());
        Patient patient = new Patient();
        patient.setNom("karim");
        patient.setPrenom("AMINE");
        patient.setTel("123456789");
        service.addPatient(patient);
    }

}
