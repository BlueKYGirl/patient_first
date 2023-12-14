-- **************************************************************
-- This script creates "spoof" data for testing in the final_capstone database
-- **************************************************************

BEGIN TRANSACTION;

INSERT INTO person(user_id, first_name, last_name, email, date_of_birth)
VALUES (1, 'Richie', 'Cunningham', 'rcun@patientfirst.com', '1985-09-07'),
	   (2, 'Adam', 'Admin', 'jcha@patientfirst.com', '1985-09-07'),
	   (3, 'Meredith', 'Grey', 'mgrey@patientfirst.com', '1985-09-07'),
 	   (4, 'Chachi', 'Arcola', 'carc@patientfirst.com', '1985-09-07'),
       (5, 'Joni', 'Cunningham', 'jcun@patientfirst.com', '1990-01-23'),
       (6, 'Arthur', 'Fonzarelli', 'afon@patientfirst.com', '1988-02-07'),
	   (7, 'Derek', 'McDreamy', 'dmcd@patientfirst.com', '1977-05-20'),
	   (8, 'Howard', 'Cunningham', 'ause@patientfirst.com', '1995-06-10');

INSERT INTO doctor(person_id, specialty_id, is_primary_care)
VALUES (6, 5, true),
       (4, 4, true),
       (3, 2, true),
	   (7, 5, true);

INSERT INTO address(street_address, city, state_abbreviation, zip_code)
VALUES ('500 Main Street' , 'Televille', 'PA', 13145),
	   ('600 Any Street', 'Ohmtown', 'IN', 54367),
	   ('700 Washington Ave.', 'Larryville', 'PA', 54367),
	   ('855 Military Ln.', 'Stanton', 'PA', 54367),
	   ('1234 Maple Blvd.', 'Devcreek', 'OH', 45444);

INSERT INTO phone_type(phone_type)
VALUES ('Primary');

INSERT INTO phone_number(phone_type_id, phone_number, is_primary_phone)
VALUES (1, '(123)456-7890', True);

INSERT INTO office(address_id, office_phone_number, practice_name, office_hours_start_time, office_hours_end_time)
VALUES (1, '(234)456-7890', 'Chachi & Associates', '8:00', '16:00'),
       (2, '(555)765-1670', 'Fonzarelli Family Medicine', '9:30', '17:00'),
       (3, '(999)567-2006', 'Larryville Physicians Network', '9:00', '16:30'),
       (4, '(888)510-5504', 'DevMed Health Office', '8:00', '16:30'),
       (5, '(677)543-0994', 'Patient First Family Practice', '8:00', '17:00');

INSERT INTO appointment_schedule(
	doctor_id, patient_id, appointment_date, time_block_id, office_id, appointment_reason_id, appointment_status_id, schedule_status_id)
	VALUES (3, 0, '2024-01-15', 33, 1, 1, 1, 1),
		   (3, 0, '2024-01-15', 36, 1, 1, 1, 1),
		   (3, 0, '2024-01-15', 39, 1, 1, 1, 1),
		   (3, 0, '2024-01-15', 42, 1, 1, 1, 1),
		   (3, 0, '2024-01-15', 45, 1, 1, 1, 1),
		   (3, 0, '2024-01-15', 48, 1, 1, 6, 3),
		   (3, 0, '2024-01-15', 49, 1, 1, 6, 2),
		   (3, 0, '2024-01-15', 53, 1, 1, 1, 1),
		   (3, 0, '2024-01-15', 56, 1, 1, 1, 1),
		   (3, 0, '2024-01-15', 59, 1, 1, 1, 1),
		   (3, 0, '2024-01-15', 62, 1, 1, 1, 1);


INSERT INTO doctor_office(doctor_id, office_id)
VALUES (1, 1),
       (3, 1),
	   (3, 2),
	   (3, 3),
	   (3, 4),
	   (3, 5),
	   (4, 4),
	   (4, 5);

-- INSERT INTO table_name(column1, 2, 3, etc.)
-- VALUES (a, b, c, d)


COMMIT TRANSACTION;
