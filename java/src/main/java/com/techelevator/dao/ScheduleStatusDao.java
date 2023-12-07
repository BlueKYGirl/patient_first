package com.techelevator.dao;

import com.techelevator.model.ScheduleStatusDto;

import java.util.List;

public interface ScheduleStatusDao {

    List<ScheduleStatusDto> getScheduleStatuses();
}
