package com.techelevator.model;

public class AppointmentReasonDto {

    private int appointmentReasonId;
    private String appointmentReason;

    public AppointmentReasonDto(int appointmentReasonId, String appointmentReason) {
        this.appointmentReasonId = appointmentReasonId;
        this.appointmentReason = appointmentReason;
    }

    public AppointmentReasonDto() {
    }

    public int getAppointmentReasonId() {
        return appointmentReasonId;
    }

    public void setAppointmentReasonId(int appointmentReasonId) {
        this.appointmentReasonId = appointmentReasonId;
    }

    public String getAppointmentReason() {
        return appointmentReason;
    }

    public void setAppointmentReason(String appointmentReason) {
        this.appointmentReason = appointmentReason;
    }
}
