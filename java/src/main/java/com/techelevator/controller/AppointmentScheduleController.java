package com.techelevator.controller;


import com.techelevator.dao.TimeBlockDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Doctor;
import com.techelevator.model.TimeBlockDto;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalTime;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/appointments")
@PreAuthorize("isAuthenticated()")
public class AppointmentScheduleController {

    private TimeBlockDao timeBlockDao;

    public AppointmentScheduleController(TimeBlockDao timeBlockDao) {
        this.timeBlockDao = timeBlockDao;
    }

    // *** Get a list of timeBlocks by office hours start and end ****
    @RequestMapping(path = "/times/{startTime}/{endTime}", method = RequestMethod.GET)
    public List<TimeBlockDto> getTimeBlocksByOfficeHours(@PathVariable int startTime, @PathVariable int endTime){
        try {
            List<TimeBlockDto> timeBlocks = timeBlockDao.getTimeBlocksByOfficeHours(startTime, endTime);
            return timeBlocks;
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "There are no doctors here...Bummer..." + e);
        }
    }

    @RequestMapping(path = "/alltimes", method = RequestMethod.GET)
    public List<TimeBlockDto> getAllTimeBlocks(){
        try {
            List<TimeBlockDto> timeBlocks = timeBlockDao.getAllTimeBlocks();
            return timeBlocks;
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "There are no doctors here...Bummer..." + e);
        }
    }

}
