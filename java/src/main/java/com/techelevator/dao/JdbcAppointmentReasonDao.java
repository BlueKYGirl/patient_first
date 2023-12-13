package com.techelevator.dao;

import com.techelevator.model.AppointmentReasonDto;
import com.techelevator.model.ScheduleStatusDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAppointmentReasonDao implements AppointmentReasonDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcAppointmentReasonDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<AppointmentReasonDto> getAppointmentReasons() {
        List<AppointmentReasonDto> appointmentReasons = new ArrayList<>();
        String sql = "SELECT appointment_reason_id, appointment_reason FROM appointment_reason;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            appointmentReasons.add(mapRowToAppointmentReasonDto(results));
        }
        return appointmentReasons;
    }

    private AppointmentReasonDto mapRowToAppointmentReasonDto(SqlRowSet rowSet) {
        AppointmentReasonDto appointmentReasonDto = new AppointmentReasonDto();
        appointmentReasonDto.setAppointmentReasonId(rowSet.getInt("appointment_reason_id"));
        appointmentReasonDto.setAppointmentReason(rowSet.getString("appointment_reason"));

        return appointmentReasonDto;
    }


}
