package com.techelevator.model;

import java.time.LocalDate;

public class Doctor extends Person {

    private int doctorId;
    private String specialty;
    private boolean isPrimaryCare;

    // **** Constructors ****

    public Doctor(int userId, String firstName, String lastName, String emailAddress, LocalDate dateOfBirth, int doctorId, String specialty, boolean primaryCare) {
        super(userId, firstName, lastName, emailAddress, dateOfBirth);
        this.doctorId = doctorId;
        this.specialty = specialty;
        this.isPrimaryCare = isPrimaryCare;
    }

    public Doctor() {};


    // **** Getters and Setters ****

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public boolean isPrimaryCare() {
        return isPrimaryCare;
    }

    public void setIsPrimaryCare(boolean primaryCare) {
        this.isPrimaryCare = isPrimaryCare;
    }
}
