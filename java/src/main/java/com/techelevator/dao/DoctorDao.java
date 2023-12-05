package com.techelevator.dao;

import com.techelevator.model.Doctor;

import java.util.List;

public interface DoctorDao {

    List<Doctor> getAllDoctors();

    List<Doctor> getDoctorsByOfficeId(int officeId);
}
