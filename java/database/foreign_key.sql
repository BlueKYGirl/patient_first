-- **************************************************************
-- This script applies the foreign keys to the tables generated to keep linking them easier
-- **************************************************************

BEGIN TRANSACTION;

-- ********************* Person Table & Connection Tables ***********************

ALTER TABLE person
    ADD CONSTRAINT FK_person_users
        FOREIGN KEY (user_id) REFERENCES users(user_id);

ALTER TABLE person_address
    ADD CONSTRAINT FK_person_address_person
        FOREIGN KEY (person_id) REFERENCES person (person_id),
	ADD CONSTRAINT FK_person_address_address
        FOREIGN KEY (address_id) REFERENCES address (address_id);

ALTER TABLE person_phone
    ADD CONSTRAINT FK_person_phone_person
        FOREIGN KEY (person_id) REFERENCES person (person_id),
	ADD CONSTRAINT FK_person_phone_phone_number
        FOREIGN KEY (phone_id) REFERENCES phone_number (phone_id);


-- ********************* Phone Number Table *********************** 

ALTER TABLE phone_number
    ADD CONSTRAINT FK_phone_number_phone_type
        FOREIGN KEY (phone_type_id) REFERENCES phone_type (phone_type_id);


-- ********************* Appointment Table *********************** 

ALTER TABLE appointment_schedule
    ADD CONSTRAINT FK_appointment_schedule_doctor
        FOREIGN KEY (doctor_id) REFERENCES doctor (doctor_id),
    ADD CONSTRAINT FK_appointment_schedule_person
        FOREIGN KEY (patient_id) REFERENCES person (person_id),
    ADD CONSTRAINT FK_appointment_schedule_time_block
        FOREIGN KEY (time_block_id) REFERENCES time_block (time_block_id),
    ADD CONSTRAINT FK_appointment_schedule_office
        FOREIGN KEY (office_id) REFERENCES office (office_id),
    ADD CONSTRAINT FK_appointment_schedule_appointment_reason
        FOREIGN KEY (appointment_reason_id) REFERENCES appointment_reason (appointment_reason_id),
    ADD CONSTRAINT FK_appointment_schedule_appointment_status
        FOREIGN KEY (appointment_status_id) REFERENCES appointment_status (appointment_status_id),
    ADD CONSTRAINT FK_appointment_schedule_schedule_status
        FOREIGN KEY (schedule_status_id) REFERENCES schedule_status (schedule_status_id);

-- ********************* Doctor Table & Connection Tables *********************** 

ALTER TABLE doctor
    ADD CONSTRAINT FK_doctor_person
        FOREIGN KEY (person_id) REFERENCES person (person_id), 
    ADD CONSTRAINT FK_doctor_specialty
        FOREIGN KEY (specialty_id) REFERENCES specialty (specialty_id); 

ALTER TABLE doctor_office
    ADD CONSTRAINT FK_doctor_office_doctor
        FOREIGN KEY (doctor_id) REFERENCES doctor (doctor_id),
	ADD CONSTRAINT FK_doctor_office_office
        FOREIGN KEY (office_id) REFERENCES office (office_id);

ALTER TABLE doctor_review
    ADD CONSTRAINT FK_doctor_review_doctor
        FOREIGN KEY (doctor_id) REFERENCES doctor (doctor_id),
	ADD CONSTRAINT FK_doctor_review_review
        FOREIGN KEY (review_id) REFERENCES review (review_id);

-- ********************* Office Table *********************** 

ALTER TABLE office
    ADD CONSTRAINT FK_office_address
        FOREIGN KEY (address_id) REFERENCES address (address_id);

-- ********************* Review Table *********************** 

ALTER TABLE review
    ADD CONSTRAINT FK_review_doctor
        FOREIGN KEY (doctor_id) REFERENCES doctor (doctor_id),
    ADD CONSTRAINT FK_review_person
        FOREIGN KEY (person_id) REFERENCES person (person_id); 


COMMIT TRANSACTION;