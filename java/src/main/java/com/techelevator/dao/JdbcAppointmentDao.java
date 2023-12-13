package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

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

    public Appointment updateAppointment(AppointmentDto apptDto){
        // **** had issues with getting the LocalDate in the JSON from the front end.  Created DTO in order to get the date
        //      as a string, and then parse it as a LocalDate. ***
        Appointment appointment = mapApptDtoToAppointment(apptDto);
        Appointment updatedAppt = null;

        String sql = "UPDATE appointment_schedule SET doctor_id=?, patient_id=?, appointment_date=?, " +
                        "time_block_id=?, office_id=?, appointment_reason_id=?, appointment_status_id=?, schedule_status_id=? " +
                        "WHERE appointment_id = ?;";

        try {
            int numberOfRows = jdbcTemplate.update(sql, appointment.getDoctorId(), appointment.getPatientId(), appointment.getDate(), appointment.getTimeBlockId(),
                        appointment.getOfficeId(), appointment.getAppointmentReasonId(), appointment.getAppointmentStatusId(), appointment.getScheduleStatusId(), appointment.getAppointmentId());
            if (numberOfRows == 0) {
                throw new DaoException("Zero rows affected. Something's wrong updating department_id: " + appointment.getAppointmentId());
            } else {
                updatedAppt = getAppointmentById(appointment.getAppointmentId());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server.  Server go boom!", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data Integrity Violation!", e);
        } catch (Exception e) {
            throw new DaoException("Something is wrong!!", e);
        }
        return updatedAppt;
    }


    public List<Appointment> getAvailableAppointmentsByDoctorId(int doctorId){
        List<Appointment> availableAppts = new ArrayList<>();
        int apptStatus = 1;                             // this is the value for "Available" appointments
        String sql = "SELECT appointment_id, doctor_id, patient_id, appointment_date, time_block_id, office_id, appointment_reason_id, appointment_status_id, schedule_status_id " +
                "FROM appointment_schedule " +
                "WHERE appointment_status_id = ? AND doctor_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, apptStatus, doctorId);
            while(results.next()) {
                availableAppts.add(mapRowToAppointment(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return availableAppts;
    }


    @Override
    public List<AgendaDto> getDoctorAgendaByDate(int doctorId, LocalDate date){
        List<AgendaDto> agenda = new ArrayList<>();
        String sql = "SELECT a.appointment_id, a.doctor_id, a.patient_id, (p.first_name || ' ' || p.last_name) AS patient_name, a.appointment_date, a.time_block_id, " +
                            "tb.start_time, a.office_id, apr.appointment_reason, aps.appointment_status, ss.schedule_status " +
                     "FROM appointment_schedule a " +
                     "JOIN person p ON a.patient_id = p.person_id " +
                     "JOIN time_block tb ON a.time_block_id = tb.time_block_id " +
                     "JOIN schedule_status ss ON a.schedule_status_id = ss.schedule_status_id " +
                     "JOIN appointment_status aps ON a.appointment_status_id = aps.appointment_status_id " +
                     "JOIN appointment_reason apr ON a.appointment_reason_id = apr.appointment_reason_id " +
                     "WHERE a.doctor_id = ? AND a.appointment_date = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId, date);
            while (results.next()) {
                agenda.add(mapRowToAgendaDto(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return agenda;
    }

    @Override
    public List<AgendaDto> getDoctorAgenda(int doctorId){
        List<AgendaDto> agenda = new ArrayList<>();
        String sql = "SELECT a.appointment_id, a.doctor_id, a.patient_id, (p.first_name || ' ' || p.last_name) AS patient_name, a.appointment_date, a.time_block_id, " +
                "tb.start_time, a.office_id, apr.appointment_reason, aps.appointment_status, ss.schedule_status " +
                "FROM appointment_schedule a " +
                "JOIN person p ON a.patient_id = p.person_id " +
                "JOIN time_block tb ON a.time_block_id = tb.time_block_id " +
                "JOIN schedule_status ss ON a.schedule_status_id = ss.schedule_status_id " +
                "JOIN appointment_status aps ON a.appointment_status_id = aps.appointment_status_id " +
                "JOIN appointment_reason apr ON a.appointment_reason_id = apr.appointment_reason_id " +
                "WHERE a.doctor_id = ? ORDER BY a.appointment_id;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId);
            while (results.next()) {
                agenda.add(mapRowToAgendaDto(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return agenda;
    }


    //  ***** SAVING ORIGINAL GET PLAIN APPOINTMENT OBJECT IN CASE WE NEED IT LATER *****
//    @Override
//    public List<Appointment> getDoctorAgendaByDate(int doctorId, LocalDate date){
//        List<Appointment> agenda = new ArrayList<>();
//        String sql = "SELECT appointment_id, doctor_id, patient_id, appointment_date, time_block_id, office_id, appointment_reason_id, appointment_status_id, schedule_status_id " +
//                "FROM appointment_schedule " +
//                "WHERE doctor_id = ? AND appointment_date = ?;";
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId, date);
//        while (results.next()) {
//            agenda.add(mapRowToAppointment(results));
//        }
//        return agenda;
//    }


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
    public void createAppointments(List<Appointment> appointments) {
        for (Appointment appt : appointments) {
            createAppointment(appt);
        }


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

    private Appointment mapApptDtoToAppointment(AppointmentDto apptDto) {
        Appointment appt = new Appointment();
        appt.setAppointmentId(apptDto.getAppointmentId());
        appt.setDoctorId(apptDto.getDoctorId());
        appt.setPatientId(apptDto.getPatientId());
        appt.setDate(LocalDate.parse(apptDto.getDate()));
        appt.setTimeBlockId(apptDto.getTimeBlockId());
        appt.setOfficeId(apptDto.getOfficeId());
        appt.setAppointmentReasonId(apptDto.getAppointmentReasonId());
        appt.setAppointmentStatusId(apptDto.getAppointmentStatusId());
        appt.setScheduleStatusId(apptDto.getScheduleStatusId());

        return appt;
    }

    private AgendaDto mapRowToAgendaDto(SqlRowSet rowSet) {
        AgendaDto agendaDto = new AgendaDto();
        agendaDto.setAppointmentId(rowSet.getInt("appointment_id"));
        agendaDto.setDoctorId(rowSet.getInt("doctor_id"));
        agendaDto.setPatientId(rowSet.getInt("patient_id"));
        agendaDto.setPatientName(rowSet.getString("patient_name"));
        agendaDto.setDate(rowSet.getDate("appointment_date").toLocalDate());
        agendaDto.setTimeBlockId(rowSet.getInt("time_block_id"));
        agendaDto.setStartTime(rowSet.getTime("start_time").toLocalTime());
        agendaDto.setOfficeId(rowSet.getInt("office_id"));
        agendaDto.setAppointmentReason(rowSet.getString("appointment_reason"));
        agendaDto.setAppointmentStatus(rowSet.getString("appointment_status"));
        agendaDto.setScheduleStatus(rowSet.getString("schedule_status"));

        return agendaDto;
    }
}

