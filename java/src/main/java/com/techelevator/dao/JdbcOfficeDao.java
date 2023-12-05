package com.techelevator.dao;

import com.techelevator.model.Office;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcOfficeDao implements OfficeDao {

    private final JdbcTemplate jdbcTemplate;

    private DoctorDao doctorDao;

    public JdbcOfficeDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.doctorDao = doctorDao;
    }


    @Override
    public List<Office> getAllOffices() {
        List<Office> allOffices = new ArrayList<>();
        String sql = "SELECT o.office_id, o.practice_name, a.street_address, a.city, a.state_abbreviation, a.zip_code " +
                            "o.office_phone_number, o.office_hours_start_time, o.office_hours_end_time" +
                     "FROM office o " +
                     "JOIN address a ON o.address_id = a.address_id;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            allOffices.add(mapRowToOffice(results));
        }
        return allOffices;
    }

    @Override
    public List<Office> getOfficesByDoctorId(int doctorId) {
        List<Office> offices = new ArrayList<>();
        String sql = "SELECT o.office_id, o.practice_name, a.street_address, a.city, a.state_abbreviation, a.zip_code " +
                "o.office_phone_number, o.office_hours_start_time, o.office_hours_end_time " +
                "FROM office o " +
                "JOIN address a ON o.address_id = a.address_id " +
                "JOIN doctor_office dof ON o.office_id = dof.office_id " +
                "WHERE doctor_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId);
        while (results.next()) {
            offices.add(mapRowToOffice(results));
        }
        return offices;
    }


    @Override
    public Office getOfficeById(int officeId){


        return null;
    }

    @Override
    public Office createOffice(Office office) {


        return null;
    }


    @Override
    public Office updateOffice(Office office){


        return null;
    }

    private Office mapRowToOffice(SqlRowSet rowSet) {
        Office office = new Office();
        office.setOfficeId(rowSet.getInt("office_id"));
        office.setPracticeName(rowSet.getString("practice_name"));
        office.setStreetAddress(rowSet.getString("street_address"));
        office.setCity(rowSet.getString("city"));
        office.setStateAbbreviation(rowSet.getString("state_abbreviation"));
        office.setZipcode(rowSet.getString("zip_code"));
        office.setPhone(rowSet.getString("office_phone_number"));
        office.setOfficeHoursStart(rowSet.getTime("office_hours_start_time").toLocalTime());
        office.setOfficeHoursEnd(rowSet.getTime("office_hours_end_time").toLocalTime());
        office.setDoctorsInOffice(doctorDao.getDoctorsByOfficeId(rowSet.getInt("office_id")));

        return office;
    }
}
