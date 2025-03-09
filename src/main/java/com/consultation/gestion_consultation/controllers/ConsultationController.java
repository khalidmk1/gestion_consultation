package com.consultation.gestion_consultation.controllers;

import com.consultation.gestion_consultation.dao.ConsultationDao;
import com.consultation.gestion_consultation.dao.PatientDao;
import com.consultation.gestion_consultation.entities.Consultation;
import com.consultation.gestion_consultation.entities.Patient;
import com.consultation.gestion_consultation.service.ConsultationService;
import com.consultation.gestion_consultation.service.IConsulteService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;


public class ConsultationController implements Initializable {
    @FXML private DatePicker DatePickerConsultation;
    @FXML private ChoiceBox<Patient> ChoiseBoxPatient;
    @FXML private TextArea TextEreaDescription;

    @FXML private TableView<Consultation> TableConsultation;
    @FXML private TableColumn<Consultation, Long> ColumnId;
    @FXML private TableColumn<Consultation, Date> ColumnConsultation;
    @FXML private TableColumn<Consultation, Patient> ColumnPatient;
    @FXML private TableColumn<Consultation, String> ClumnDescription;

    private IConsulteService iConsulteService;
    private ObservableList<Patient> obsPatient = FXCollections.observableArrayList();
    private ObservableList<Consultation> obsConsultation = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        iConsulteService = new ConsultationService(new PatientDao() , new ConsultationDao());
        ChoiseBoxPatient.setItems(obsPatient);

        ColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        ColumnPatient.setCellValueFactory(new PropertyValueFactory<>("patient"));
        ClumnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        ColumnConsultation.setCellValueFactory(new PropertyValueFactory<>("dateConsultation"));
        TableConsultation.setItems(obsConsultation);

        obsConsultation.setAll(iConsulteService.getALLConsultations());
        obsPatient.setAll(iConsulteService.getALLPatients());
    }

    public void addConsultation(){
        Consultation consultation = new Consultation();
        consultation.setPatient(ChoiseBoxPatient.getValue());
        consultation.setDescription(TextEreaDescription.getText());
        consultation.setDateConsultation(Date.valueOf(DatePickerConsultation.getValue()));
        iConsulteService.addConsultation(consultation);
        obsConsultation.setAll(iConsulteService.getALLConsultations());
    }

    public void supprimerConsultation(){
        Consultation consultation = TableConsultation.getSelectionModel().getSelectedItem();
        iConsulteService.deleteConsultation(consultation);
        obsConsultation.setAll(iConsulteService.getALLConsultations());
    }
}
