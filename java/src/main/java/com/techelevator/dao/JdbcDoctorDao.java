package com.techelevator.dao;

import com.techelevator.model.Doctor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
public class JdbcDoctorDao implements DoctorDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcDoctorDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Doctor> getDoctorsByOfficeId(int officeId) {
        List<Doctor> doctorsInOffice = new ArrayList<>();
        String sql = "SELECT d.doctor_id, d.specialty, d.primary_care, p.user_id, p.first_name, p.last_name, p.email, p.date_of_birth, " +
                            "do.office_id " +
                     "FROM doctor d " +
                     "JOIN person p ON d.doctor_id = p.person_id " +
                     "JOIN doctor_office do ON d.doctor_id = do.doctor_id " +
                     "WHERE do.office_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, officeId);
        while (results.next()) {
            doctorsInOffice.add(mapRowToDoctor(results));
        }
        return doctorsInOffice;
    }

    private Doctor mapRowToDoctor(SqlRowSet rowSet) {
        Doctor doctor = new Doctor();
        doctor.setUserId(rowSet.getInt("user_id"));
        doctor.setFirstName(rowSet.getString("first_name"));
        doctor.setLastName(rowSet.getString("last_name"));
        doctor.setEmailAddress(rowSet.getString("email"));
        doctor.setDateOfBirth(rowSet.getDate("date_of_birth").toLocalDate());
        doctor.setDoctorId(rowSet.getInt("doctor_id"));
        doctor.setSpecialty(rowSet.getString("specialty"));
        doctor.setIsPrimaryCare(rowSet.getBoolean("primary_care"));

        return doctor;
    }
}
