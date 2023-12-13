package com.techelevator.dao;

import com.techelevator.model.AppointmentReasonDto;

import java.util.List;

public interface AppointmentReasonDao {

    List<AppointmentReasonDto> getAppointmentReasons();
}
