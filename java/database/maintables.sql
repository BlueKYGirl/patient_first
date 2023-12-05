BEGIN TRANSACTION;

DROP TABLE IF EXISTS person, doctor, office, address, phone_number, 
                     specialty, doctor_office, person_address, person_phone,
                     phone_type;


CREATE TABLE person (
	person_id SERIAL,
    user_id int NOT NULL,
	first_name varchar (20) NOT NULL,
	last_name varchar (20) NOT NULL,
	email varchar(50) NOT NULL,
    date_of_birth DATE NOT NULL,
	CONSTRAINT PK_person PRIMARY KEY (person_id)
);


CREATE TABLE doctor (
    doctor_id SERIAL,
    person_id int NOT NULL,
    specialty_id int NOT NULL, 
    is_primary_care boolean NOT NULL,
    CONSTRAINT PK_doctor PRIMARY KEY (doctor_id)
);


CREATE TABLE office (
    office_id SERIAL,
    address_id int NOT NULL,
    office_phone_number varchar(12) NOT NULL, 
    practice_name varchar (20) NOT NULL, 
    office_hours_start_time TIME NOT NULL, 
    office_hours_end_time TIME NOT NULL, 
    CONSTRAINT PK_office PRIMARY KEY (office_id)
);

CREATE TABLE address (
    address_id SERIAL,
    street_address varchar (50) NOT NULL, 
    city varchar (20) NOT NULL, 
    state_abbreviation varchar (20) NOT NULL, 
    zip_code varchar (10) NOT NULL,
    CONSTRAINT PK_address PRIMARY KEY (address_id)
);

CREATE TABLE phone_number (
    phone_id SERIAL, 
    phone_type_id int NOT NULL, 
    phone_number varchar (12) NOT NULL, 
    is_primary_phone boolean NOT NULL,
    CONSTRAINT PK_phone_number PRIMARY KEY (phone_id)
);

CREATE TABLE specialty (
    specialty_id SERIAL,
    specialty_name varchar (20) NOT NULL,
    CONSTRAINT PK_specialty PRIMARY KEY (specialty_id)
);

CREATE TABLE doctor_office (
    doctor_id int NOT NULL,
    office_id int NOT NULL,
    CONSTRAINT PK_doctor_office PRIMARY KEY (doctor_id, office_id)
);

CREATE TABLE person_address (
    person_id int NOT NULL,
    address_id int NOT NULL,
    CONSTRAINT PK_person_address PRIMARY KEY (person_id, address_id)
);

CREATE TABLE person_phone (
    person_id int NOT NULL,
    phone_id int NOT NULL,
    CONSTRAINT PK_person_phone PRIMARY KEY (person_id, phone_id)
);


CREATE TABLE phone_type (
    phone_type_id SERIAL,
    phone_type varchar (10) NOT NULL,
    CONSTRAINT PK_phone_type PRIMARY KEY (phone_type_id)
);

CREATE TABLE appointment (
    appointment_id SERIAL, 
    doctor_id int NOT NULL,
    patient_id int NOT NULL,
    time_block_id int NOT NULL, 
    office_id int NOT NULL, 
    appointment_reason_id int NOT NULL,
    appointment_status int NOT NULL,
    CONSTRAINT PK_appointment PRIMARY KEY (appointment_id)
);

CREATE TABLE review (
    review_id SERIAL,
    doctor_id int NOT NULL,
    person_id int, 
    rating int NOT NULL, 
    review text NOT NULL, 
    review_title text NOT NULL, 
    review_timestamp datetime NOT NULL,
    CONSTRAINT PK_review PRIMARY KEY (review_id)
);

CREATE TABLE doctor_review (
    doctor_id int NOT NULL, 
    review_id int NOT NULL, 
    CONSTRAINT PK_doctor_review PRIMARY KEY (doctor_id, review_id)
);

CREATE TABLE appointment_status (
    appointment_status_id SERIAL,
    status varchar (50) NOT NULL,
    CONSTRAINT PK_appointment_status PRIMARY KEY (appointment_status_id)
);


CREATE TABLE appointment_reason (
    appointment_reason_id SERIAL,
    reason varchar (50) NOT NULL,
    CONSTRAINT PK_appointment_reason PRIMARY KEY (appointment_reason_id)
);

CREATE TABLE time_block (
    time_block_id SERIAL,
    start_time time NOT NULL,
    CONSTRAINT PK_time_block PRIMARY KEY (time_block_id)
);

COMMIT TRANSACTION;