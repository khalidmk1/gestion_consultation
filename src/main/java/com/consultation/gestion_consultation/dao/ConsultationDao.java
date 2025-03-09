package com.consultation.gestion_consultation.dao;

import com.consultation.gestion_consultation.entities.Consultation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultationDao implements IConsultationDao{
    @Override
    public void create(Consultation consultation) throws SQLException {
        Connection con = BDConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("INSERT INTO CONSULTATION(DATE_CONSULTATION , DESCRIPTION , ID_PATIENT)" + "VALUE(?,?,?)");
        ps.setDate(1, consultation.getDateConsultation());
        ps.setString(2, consultation.getDescription());
        ps.setLong(3 , consultation.getPatient().getId());
        ps.executeUpdate();
    }

    @Override
    public void update(Consultation consultation) throws SQLException {
        Connection con = BDConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("UPDATE CONSULTATION SET DESCRIPTION = ? , DATE_CONSULTATION = ? , ID_PATIENT = ? WHERE ID_CONSULTATION = ? ");
        ps.setString(1, consultation.getDescription());
        ps.setDate(2, consultation.getDateConsultation());
        ps.setLong(3 , consultation.getPatient().getId());
        ps.executeUpdate();
    }

    @Override
    public void delete(Consultation consultation) throws SQLException {
        Connection con = BDConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("DELETE FROM CONSULTATION WHERE ID_CONSULTATION = ?");
        ps.setLong(1, consultation.getId());
        ps.executeUpdate();
    }

    @Override
    public List<Consultation> findAll() throws SQLException {
        Connection con = BDConnection.getConnection();
        PreparedStatement pstm = con.prepareStatement("SELECT * FROM CONSULTATION");
        ResultSet rs = pstm.executeQuery();
        List<Consultation> consultations = new ArrayList<>();
        while (rs.next()) {
            Consultation consultation = new Consultation();
            consultation.setId(rs.getLong("ID_CONSULTATION"));
            consultation.setDateConsultation(rs.getDate("DATE_CONSULTATION"));
            consultation.setDescription(rs.getString("DESCRIPTION"));
            consultation.setPatient(new PatientDao().findById(rs.getLong("ID_PATIENT")));
            consultations.add(consultation);
        }
        return consultations;
    }

    @Override
    public Consultation findById(Long id) throws SQLException {
        Connection con = BDConnection.getConnection();
        PreparedStatement pstm = con.prepareStatement("SELECT FROM CONSULTATION WHERE ID_CONSULTATION = ?");
        pstm.setLong(1, id);
        ResultSet rs = pstm.executeQuery();
        Consultation consultation = new Consultation();
        while (rs.next()) {
            consultation.setId(rs.getLong("ID_CONSULTATION"));
            consultation.setDateConsultation(rs.getDate("DATE_CONSULTATION"));
            consultation.setDescription(rs.getString("DESCRIPTION"));
            consultation.setPatient(new PatientDao().findById(rs.getLong("ID_PATIENT")));
        }
        return consultation;
    }
}
