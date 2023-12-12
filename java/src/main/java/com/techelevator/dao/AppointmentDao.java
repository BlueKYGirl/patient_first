package com.techelevator.dao;

import com.techelevator.model.Appointment;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentDao {

    Appointment getAppointmentById(int appointmentId);

    List<Appointment> getDoctorAgendaByDate(int doctorId, LocalDate date);

    void createAppointments(List<Appointment> appointments);

    Appointment createAppointment(Appointment appointment);
}
