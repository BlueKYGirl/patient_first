package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Doctor;
import com.techelevator.model.Office;
import org.apache.tomcat.jni.Address;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcOfficeDao implements OfficeDao {

    private final JdbcTemplate jdbcTemplate;

    private DoctorDao doctorDao;

    public JdbcOfficeDao(DataSource dataSource, DoctorDao doctorDao) {
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
        String sql = "SELECT o.office_id, o.practice_name, a.street_address, a.city, a.state_abbreviation, a.zip_code, " +
                "o.office_phone_number, o.office_hours_start_time, o.office_hours_end_time " +
                "FROM office o " +
                "JOIN address a ON o.address_id = a.address_id " +
                "JOIN doctor_office dof ON o.office_id = dof.office_id " +
                "WHERE dof.doctor_id = ?;";
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
    // Creates Address
        String sqlAddress = "INSERT INTO address (street_address, city, state_abbreviation, zip_code) " +
                            "VALUES (?, ?, ?, ?) " +
                            "RETURNING address_id;";
        int newAddressId;
        try {
            newAddressId = jdbcTemplate.update(sqlAddress, int.class, office.getStreetAddress(), office.getCity(), office.getStateAbbreviation(), office.getZipcode());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database. ", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("A Data Integrity Violation has occurred. ", e);
        } catch (Exception e) {
            throw new DaoException("An unknown error occurred.  Contact your system administrator. ", e);
        }
    // Creates Office
        String sqlOffice = "INSERT INTO office (address_id, office_phone_number, practice_name, office_hours_start_time, office_hours_end_time) " +
                           "VALUES (?, ?, ?, ?, ?) " +
                           "RETURNING office_id;";
        int newOfficeId;
        try {
            newOfficeId = jdbcTemplate.update(sqlOffice, newAddressId, office.getPhone(), office.getPracticeName(), office.getOfficeHoursStart(), office.getOfficeHoursEnd());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database. ", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("A Data Integrity Violation has occurred. ", e);
        } catch (Exception e) {
            throw new DaoException("An unknown error occurred.  Contact your system administrator. ", e);
        }

    // Add Doctor(s) to Office -- Not entirely sure right off the rip how to iterate through the list to add each pairing
        String sqlDoctorsInOffice = "INSERT INTO doctor_office (doctor_id, office_id) " +
                                    "VALUES (?, ?);";
        for (Doctor doctor : office.getDoctorsInOffice()){
            jdbcTemplate.update(sqlDoctorsInOffice, doctor.getDoctorId(), newOfficeId);
        }

    // Return the fully populated office object
        return office;
    }



   // TODO: Fix this method.
    @Override
    public Office updateOffice(Office office){
        String sqlAddress = "UPDATE address a " +
                            "SET a.street_address = ?, a.city = ?, a.state_abbreviation = ?, a.zip_code = ?, " +
                            "o.office_phone_number = ?, o.practice_name = ?, o.office_hours_start_time = ?, o.office_hours_end_time = ? " +
                            "JOIN office o ON a.address_id = o.address_id " +
                            "WHERE office_id = ?;";
        //jdbcTemplate.update(sqlAddress, office.getStreetAddress(), office.getCity(), office.getStateAbbreviation(), office.getZipcode(), /* Need to figure out what to do for this...Don't have an address_id in our objects );*/
        // Will need to flesh out the update Office part of this, not just the address...Will do that ASAP



       return null;
    }

    private Office mapRowToOffice(SqlRowSet rowSet) {
        Office office = new Office();
        int officeId = rowSet.getInt("office_id");
        office.setOfficeId(officeId);
        office.setPracticeName(rowSet.getString("practice_name"));
        office.setStreetAddress(rowSet.getString("street_address"));
        office.setCity(rowSet.getString("city"));
        office.setStateAbbreviation(rowSet.getString("state_abbreviation"));
        office.setZipcode(rowSet.getString("zip_code"));
        office.setPhone(rowSet.getString("office_phone_number"));
        office.setOfficeHoursStart(rowSet.getTime("office_hours_start_time").toLocalTime());
        office.setOfficeHoursEnd(rowSet.getTime("office_hours_end_time").toLocalTime());
        office.setDoctorsInOffice(doctorDao.getDoctorsByOfficeId(officeId));

        return office;
    }
}
