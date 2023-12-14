package com.techelevator.dao;

import com.techelevator.model.AgendaDto;
import com.techelevator.model.Appointment;
import com.techelevator.model.AppointmentDto;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentDao {

    Appointment getAppointmentById(int appointmentId);

    Appointment updateAppointment(AppointmentDto appointmentDto);

    List<AgendaDto> getDoctorAgenda(int doctorId);

    List<Appointment> getAvailableAppointmentsByDoctorId(int doctorId);

    List<Appointment> getAppointmentsByPatientId(int patientId);

    List<AgendaDto> getDoctorAgendaByDate(int doctorId, LocalDate date);

    void createAppointments(List<Appointment> appointments);

    Appointment createAppointment(Appointment appointment);
}
