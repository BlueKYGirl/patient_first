package com.techelevator.dao;

import com.techelevator.model.Doctor;
import com.techelevator.model.Office;

import java.util.List;

public interface OfficeDao {


    List<Office> getAllOffices();

    List<Office> getOfficesByDoctorId(int doctorId);

    Office getOfficeById(int officeId);

    Office createOffice(Office office);

    void addDoctorsToOfficeByOfficeId(List<Doctor> doctors, int officeId);


    Office updateOfficeById(Office office);
}
