package com.techelevator.controller;


import com.techelevator.dao.DoctorDao;
import com.techelevator.dao.OfficeDao;
import com.techelevator.dao.UserDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Doctor;
import com.techelevator.model.Office;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/doctors")
@PreAuthorize("isAuthenticated()")
public class DoctorController {

    private UserDao userDao;
    private DoctorDao doctorDao;
    private OfficeDao officeDao;

    public DoctorController(UserDao userDao, DoctorDao doctorDao, OfficeDao officeDao) {
        this.userDao = userDao;
        this.doctorDao = doctorDao;
        this.officeDao = officeDao;
    }


     // Get All Doctors *************************************
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Doctor> getAllDoctors(){
        try {
            List<Doctor> doctors = doctorDao.getAllDoctors();
            return doctors;
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "There are no doctors here...Bummer..." + e);
        }
    }

    // Get Office(s) by Doctor *************************************
    @RequestMapping(path = "/{doctorId}/offices", method = RequestMethod.GET)
    public List<Office> getOfficesByDoctorId(@PathVariable("doctorId") int doctorId){
        try {
            List<Office> offices = officeDao.getOfficesByDoctorId(doctorId);
            return offices;
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "This doctor doesn't have an office...Sad." + e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Scientfic Postgres  " + e);
        }
    }

}
