package com.techelevator.controller;


import com.techelevator.dao.AppointmentDao;
import com.techelevator.dao.ScheduleStatusDao;
import com.techelevator.dao.TimeBlockDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.*;
import org.apache.tomcat.jni.Local;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/appointments")
@PreAuthorize("isAuthenticated()")
public class AppointmentScheduleController {

    private TimeBlockDao timeBlockDao;
    private ScheduleStatusDao scheduleStatusDao;

    private AppointmentDao appointmentDao;

    public AppointmentScheduleController(TimeBlockDao timeBlockDao, ScheduleStatusDao scheduleStatusDao, AppointmentDao appointmentDao) {
        this.timeBlockDao = timeBlockDao;
        this.scheduleStatusDao = scheduleStatusDao;
        this.appointmentDao = appointmentDao;
    }

    // *** Get AGENDA: a list of appointments by Doctor ID and date  ****
    @CrossOrigin
    @RequestMapping(path = "/agenda/{doctorId}/{date}", method = RequestMethod.GET)
    public List<Appointment> getDoctorAgenda(@PathVariable int doctorId, @PathVariable String date){
        LocalDate appt_date = LocalDate.parse(date);
        try {
            List<Appointment> agenda = appointmentDao.getDoctorAgendaByDate(doctorId, appt_date);
            return agenda;
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "There are no appointments here...Bummer..." + e);
        }
    }

    // *** Create a list of appointments from the Doctor Availability page  ****
    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/agenda/add", method = RequestMethod.POST)
    public void createAppointments( @RequestBody List<Appointment> appointments){
        try {
            appointmentDao.createAppointments(appointments);

        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "User registration failed." + e);
        }
    }

    // *** Get a list of timeBlocks by office hours start and end ****
    @CrossOrigin
    @RequestMapping(path = "/times/{startTime}/{endTime}", method = RequestMethod.GET)
    public List<TimeBlockDto> getTimeBlocksByOfficeHours(@PathVariable int startTime, @PathVariable int endTime){
        try {
            List<TimeBlockDto> timeBlocks = timeBlockDao.getTimeBlocksByOfficeHours(startTime, endTime);
            return timeBlocks;
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "There are no doctors here...Bummer..." + e);
        }
    }
    @CrossOrigin
    @RequestMapping(path = "/alltimes", method = RequestMethod.GET)
    public List<TimeBlockDto> getAllTimeBlocks(){
        try {
            List<TimeBlockDto> timeBlocks = timeBlockDao.getAllTimeBlocks();
            return timeBlocks;
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "There are no doctors here...Bummer..." + e);
        }
    }

    @CrossOrigin
    @RequestMapping(path = "/schedulestatus", method = RequestMethod.GET)
    public List<ScheduleStatusDto> getScheduleStatuses(){
        try {
            List<ScheduleStatusDto> scheduleStatuses = scheduleStatusDao.getScheduleStatuses();
            return scheduleStatuses;
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "There are no doctors here...Bummer..." + e);
        }
    }

}
