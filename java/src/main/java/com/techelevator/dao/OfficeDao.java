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
<<<<<<< HEAD

    Office updateOfficeById(Office office, int officeId);
=======
>>>>>>> 31a5ef0c3e03a58a94d526b77e09871c1069934a

    Office updateOfficeById(Office office, int officeId);
}
