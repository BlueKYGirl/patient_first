package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Appointment;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAppointmentDao implements AppointmentDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcAppointmentDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Appointment getAppointmentById(int apptId) {
        Appointment appt = null;
        String sql = "SELECT appointment_id, doctor_id, patient_id, appointment_date, time_block_id, office_id, appointment_reason_id, appointment_status_id, schedule_status_id " +
                "FROM appointment_schedule " +
                "WHERE appointment_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, apptId);
            if (results.next()) {
                appt = mapRowToAppointment(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return appt;
    }

    @Override
    public List<Appointment> getDoctorAgendaByDate(int doctorId, LocalDate date){
        List<Appointment> agenda = new ArrayList<>();
        String sql = "SELECT appointment_id, doctor_id, patient_id, appointment_date, time_block_id, office_id, appointment_reason_id, appointment_status_id, schedule_status_id " +
                     "FROM appointment_schedule " +
                     "WHERE doctor_id = ? AND appointment_date = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId, date);
        while (results.next()) {
            agenda.add(mapRowToAppointment(results));
        }
        return agenda;
    }

    @Override
    public Appointment createAppointment(Appointment appt) {
        Appointment newAppt = null;
        String sql = "INSERT INTO appointment_schedule(doctor_id, patient_id, appointment_date, time_block_id, " +
                                "office_id, appointment_reason_id, appointment_status_id, schedule_status_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?) RETURNING appointment_id;";
        try {
            int newApptId = jdbcTemplate.queryForObject(sql, int.class, appt.getDoctorId(), appt.getPatientId(), appt.getDate(), appt.getTimeBlockId(),
                                    appt.getOfficeId(), appt.getAppointmentReasonId(), appt.getAppointmentStatusId(), appt.getScheduleStatusId());
            newAppt = getAppointmentById(newApptId);

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return newAppt;
    }

    @Override
    public List<Appointment> createAppointments(List<Appointment> appointments) {
        return null;

    }

    private Appointment mapRowToAppointment(SqlRowSet rowSet) {
        Appointment appt = new Appointment();
        appt.setAppointmentId(rowSet.getInt("appointment_id"));
        appt.setDoctorId(rowSet.getInt("doctor_id"));
        appt.setPatientId(rowSet.getInt("patient_id"));
        appt.setDate(rowSet.getDate("appointment_date").toLocalDate());
        appt.setTimeBlockId(rowSet.getInt("time_block_id"));
        appt.setOfficeId(rowSet.getInt("office_id"));
        appt.setAppointmentReasonId(rowSet.getInt("appointment_reason_id"));
        appt.setAppointmentStatusId(rowSet.getInt("appointment_status_id"));
        appt.setScheduleStatusId(rowSet.getInt("schedule_status_id"));

        return appt;
    }
}
