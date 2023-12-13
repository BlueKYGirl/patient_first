package com.techelevator.model;

import java.time.LocalDate;

public class AppointmentDto {

    private int appointmentId;
    private int doctorId;
    private int patientId;
    private String date;
    private int timeBlockId;
    private int officeId;
    private int appointmentReasonId;
    private int appointmentStatusId;
    private int scheduleStatusId;

    public AppointmentDto(int appointmentId, int doctorId, int patientId, String date, int timeBlockId, int officeId, int appointmentReasonId, int appointmentStatusId, int scheduleStatusId) {
        this.appointmentId = appointmentId;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.date = date;
        this.timeBlockId = timeBlockId;
        this.officeId = officeId;
        this.appointmentReasonId = appointmentReasonId;
        this.appointmentStatusId = appointmentStatusId;
        this.scheduleStatusId = scheduleStatusId;
    }

    public AppointmentDto() {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTimeBlockId() {
        return timeBlockId;
    }

    public void setTimeBlockId(int timeBlockId) {
        this.timeBlockId = timeBlockId;
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public int getAppointmentReasonId() {
        return appointmentReasonId;
    }

    public void setAppointmentReasonId(int appointmentReasonId) {
        this.appointmentReasonId = appointmentReasonId;
    }

    public int getAppointmentStatusId() {
        return appointmentStatusId;
    }

    public void setAppointmentStatusId(int appointmentStatusId) {
        this.appointmentStatusId = appointmentStatusId;
    }

    public int getScheduleStatusId() {
        return scheduleStatusId;
    }

    public void setScheduleStatusId(int scheduleStatusId) {
        this.scheduleStatusId = scheduleStatusId;
    }
}
