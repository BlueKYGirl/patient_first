package com.techelevator.dao;

import com.techelevator.model.TimeBlockDto;

import java.time.LocalTime;
import java.util.List;

public interface TimeBlockDao {

    List<TimeBlockDto> getTimeBlocksByOfficeHours(int officeHoursStart, int officeHoursEnd);

    List<TimeBlockDto> getAllTimeBlocks();
}
