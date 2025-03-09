package com.consultation.gestion_consultation.controllers;

import com.consultation.gestion_consultation.dao.ConsultationDao;
import com.consultation.gestion_consultation.dao.PatientDao;
import com.consultation.gestion_consultation.entities.Patient;
import com.consultation.gestion_consultation.service.ConsultationService;
import com.consultation.gestion_consultation.service.IConsulteService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PatientController  implements Initializable {
    @FXML private TextField TextFiledNom;
    @FXML private TextField TextFiledPrenom;
    @FXML private TextField TextFiledTel;
    @FXML private TextField TextFiledSearch;

    @FXML private TableView<Patient> TablePatient;
    @FXML private TableColumn<Patient, Long> ColumnId;
    @FXML private TableColumn<Patient, String> ColumnNom;
    @FXML private TableColumn<Patient, String> ColumnPrenom;
    @FXML private TableColumn<Patient, String> ColumnTel;
    private IConsulteService iConsulteService;
    private ObservableList<Patient> obsPatient = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        iConsulteService = new ConsultationService(new PatientDao() , new ConsultationDao());
        ColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        ColumnNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        ColumnPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        ColumnTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        TablePatient.setItems(obsPatient);
        loadPatient();
        TextFiledSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                obsPatient.setAll(iConsulteService.searchPatientQuery(newValue));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public void addPatient(){
        Patient patient = new Patient();
        patient.setNom(TextFiledNom.getText());
        patient.setPrenom(TextFiledPrenom.getText());
        patient.setTel(TextFiledTel.getText());
        iConsulteService.addPatient(patient);
        loadPatient();
    }

    public void modifyPatient(){
        Patient patient = TablePatient.getSelectionModel().getSelectedItem();
        patient.setNom(TextFiledNom.getText());
        patient.setPrenom(TextFiledPrenom.getText());
        patient.setTel(TextFiledTel.getText());
        iConsulteService.updatePatient(patient);
        TextFiledTel.setText("");
        TextFiledPrenom.setText("");
        TextFiledNom.setText("");
        loadPatient();
    }

    public void selectPatient(){
        Patient patient = TablePatient.getSelectionModel().getSelectedItem();
        TextFiledNom.setText(patient.getNom());
        TextFiledPrenom.setText(patient.getPrenom());
        TextFiledTel.setText(patient.getTel());
    }

    public void supprimerPatient(){
        Patient patient = TablePatient.getSelectionModel().getSelectedItem();
        iConsulteService.deletePatient(patient);
        loadPatient();
    }


    private void loadPatient(){
        obsPatient.setAll(iConsulteService.getALLPatients());
    }
}
