package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class AgendaDto {
    private int appointmentId;
    private int doctorId;
    private int patientId;
    private String patientName;
    private LocalDate date;
    private int timeBlockId;
    private LocalTime startTime;
    private int officeId;
    private String appointmentReason;
    private String appointmentStatus;
    private String scheduleStatus;


    public AgendaDto(int appointmentId, int doctorId, int patientId, String patientName, LocalDate date, int timeBlockId, LocalTime startTime,
                     int officeId, String appointmentReason, String appointmentStatus, String scheduleStatus) {
        this.appointmentId = appointmentId;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.patientName = patientName;
        this.date = date;
        this.timeBlockId = timeBlockId;
        this.startTime = startTime;
        this.officeId = officeId;
        this.appointmentReason = appointmentReason;
        this.appointmentStatus = appointmentStatus;
        this.scheduleStatus = scheduleStatus;
    }

    public AgendaDto() {
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getTimeBlockId() {
        return timeBlockId;
    }

    public void setTimeBlockId(int timeBlockId) {
        this.timeBlockId = timeBlockId;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public String getAppointmentReason() {
        return appointmentReason;
    }

    public void setAppointmentReason(String appointmentReason) {
        this.appointmentReason = appointmentReason;
    }

    public String getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(String appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public String getScheduleStatus() {
        return scheduleStatus;
    }

    public void setScheduleStatus(String scheduleStatus) {
        this.scheduleStatus = scheduleStatus;
    }
}
