package com.techelevator.dao;

import com.techelevator.model.Doctor;

import java.util.List;

public interface DoctorDao {

    List<Doctor> getAllDoctors();

    Doctor getDoctorByDoctorId(int doctorId);

    List<Doctor> getDoctorsByOfficeId(int officeId);

    Doctor createDoctor(Doctor doctor);
}
