package com.consultation.gestion_consultation.entities;

import java.sql.Date;

public class Consultation {

    private Long id;
    private Date DateConsultation;
    private String Description;
    private Patient patient;

    public Consultation() {
    }

    public Consultation(Date dateConsultation, String description, Patient patient) {
        DateConsultation = dateConsultation;
        Description = description;
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateConsultation() {
        return DateConsultation;
    }

    public void setDateConsultation(Date dateConsultation) {
        DateConsultation = dateConsultation;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
