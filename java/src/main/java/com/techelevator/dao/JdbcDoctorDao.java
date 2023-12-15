package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Doctor;
import com.techelevator.model.RegisterUserDto;
import com.techelevator.model.User;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcDoctorDao implements DoctorDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcDoctorDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<Doctor> getAllDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        String sql = "SELECT d.doctor_id, s.specialty_name, d.is_primary_care, p.user_id, p.first_name, p.last_name, p.email, p.date_of_birth " +
                "FROM doctor d " +
                "JOIN specialty s ON d.specialty_id = s.specialty_id " +
                "JOIN person p ON d.person_id = p.person_id;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            doctors.add(mapRowToDoctor(results));
        }
        return doctors;
    }

    @Override
    public Doctor getDoctorByDoctorId(int doctorId) {
        Doctor doctor = null;
        String sql = "SELECT d.doctor_id, s.specialty_name, d.is_primary_care, p.user_id, p.first_name, p.last_name, p.email, p.date_of_birth " +
                "FROM doctor d " +
                "JOIN specialty s ON d.specialty_id = s.specialty_id " +
                "JOIN person p ON d.doctor_id = p.person_id " +
                "WHERE d.doctor_id = ?:";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        if (results.next()) {
            mapRowToDoctor(results);
        }
        return doctor;
    }

    @Override
    public List<Doctor> getDoctorsByOfficeId(int officeId) {
        List<Doctor> doctorsInOffice = new ArrayList<>();
        String sql = "SELECT d.doctor_id, s.specialty_name, d.is_primary_care, p.user_id, p.first_name, p.last_name, p.email, p.date_of_birth " +
                     "FROM doctor d " +
                     "JOIN specialty s ON d.specialty_id = s.specialty_id " +
                     "JOIN person p ON d.doctor_id = p.person_id " +
                     "JOIN doctor_office dof ON d.doctor_id = dof.doctor_id " +
                     "WHERE dof.office_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, officeId);
        while (results.next()) {
            doctorsInOffice.add(mapRowToDoctor(results));
        }
        return doctorsInOffice;
    }

    @Override
    public Doctor createDoctor(Doctor doctor) {
        Doctor newDoctor = null;

        String sql = "INSERT INTO doctor(person_id, specialty_id, is_primary_care) VALUES (?, ?, ?) RETURNING doctor_id;";

        // Translate specialty name (from object) into specialty_id
        int drSpecialtyId = 0;
        String specialtySql = "SELECT specialty_id FROM specialty WHERE specialty_name = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(specialtySql, doctor.getSpecialty());
        if (results.next()) {
            drSpecialtyId = results.getInt("user_id");
        }

        //Now run insert query
        try {
            int newDoctorId = jdbcTemplate.queryForObject(sql, int.class, doctor.getPersonId(), drSpecialtyId, doctor.getIsPrimaryCare());
            newDoctor = getDoctorByDoctorId(newDoctorId);


        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return newDoctor;
    }

    private Doctor mapRowToDoctor(SqlRowSet rowSet) {
        Doctor doctor = new Doctor();
        doctor.setUserId(rowSet.getInt("user_id"));
        doctor.setFirstName(rowSet.getString("first_name"));
        doctor.setLastName(rowSet.getString("last_name"));
        doctor.setEmailAddress(rowSet.getString("email"));
        doctor.setDateOfBirth(rowSet.getDate("date_of_birth").toLocalDate());
        doctor.setDoctorId(rowSet.getInt("doctor_id"));
        doctor.setSpecialty(rowSet.getString("specialty_name"));
        doctor.setIsPrimaryCare(rowSet.getBoolean("is_primary_care"));

        return doctor;
    }
}
