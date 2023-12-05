package com.techelevator.model;

import java.time.LocalTime;
import java.util.List;

public class Office {
    private int officeId;
    private String practiceName;
    private String streetAddress;
    private String city;
    private String stateAbbreviation;
    private String zipcode;
    private String phone;

    // private String phoneType;
    private LocalTime officeHoursStart;
    private LocalTime officeHoursEnd;
    private List<Doctor> doctorsInOffice;

    // **** Constructors ****

    public Office(int officeId, String practiceName, String streetAddress, String city, String stateAbbreviation,
                  String zipcode, String phone, LocalTime officeHoursStart,
                  LocalTime officeHoursEnd, List<Doctor> doctorsInOffice) {
        this.officeId = officeId;
        this.practiceName = practiceName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.stateAbbreviation = stateAbbreviation;
        this.zipcode = zipcode;
        this.phone = phone;
        // this.phoneType = phoneType;
        this.officeHoursStart = officeHoursStart;
        this.officeHoursEnd = officeHoursEnd;
        this.doctorsInOffice = doctorsInOffice;
    }

    public Office() {}


    // **** Getters and Setters ****


    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public String getPracticeName() {
        return practiceName;
    }

    public void setPracticeName(String practiceName) {
        this.practiceName = practiceName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    public void setStateAbbreviation(String stateAbbreviation) {
        this.stateAbbreviation = stateAbbreviation;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalTime getOfficeHoursStart() {
        return officeHoursStart;
    }

    public void setOfficeHoursStart(LocalTime officeHoursStart) {
        this.officeHoursStart = officeHoursStart;
    }

    public LocalTime getOfficeHoursEnd() {
        return officeHoursEnd;
    }

    public void setOfficeHoursEnd(LocalTime officeHoursEnd) {
        this.officeHoursEnd = officeHoursEnd;
    }

    public List<Doctor> getDoctorsInOffice() {
        return doctorsInOffice;
    }

    public void setDoctorsInOffice(List<Doctor> doctorsInOffice) {
        this.doctorsInOffice = doctorsInOffice;
    }
}
