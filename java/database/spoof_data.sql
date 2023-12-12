-- **************************************************************
-- This script creates "spoof" data for testing in the final_capstone database
-- **************************************************************

BEGIN TRANSACTION;

INSERT INTO person(user_id, first_name, last_name, email, date_of_birth)
VALUES (1, 'Chachi', 'TheCat', 'chachicat@meowmeow.com', '2003-01-03'),
       (2, 'Joni', 'LovesChachi', 'joni@chachicat.net', '2005-01-23'),
       (3, 'Fonz', 'Ie', 'thefonz@fonzifonzi.net', '2009-01-23');

INSERT INTO doctor(person_id, specialty_id, is_primary_care)
VALUES (1, 1, true),
       (2, 2, true),
       (3, 2, true);

INSERT INTO address(street_address, city, state_abbreviation, zip_code)
VALUES (420, 'CatTown', 'CT', 12345);

INSERT INTO phone_type(phone_type)
VALUES ('Primary');

INSERT INTO phone_number(phone_type_id, phone_number, is_primary_phone)
VALUES (1, '(123)456-7890', True);

INSERT INTO office(address_id, office_phone_number, practice_name, office_hours_start_time, office_hours_end_time)
VALUES (1, '(234)456-7890', 'Chachi & Associates', '8:00', '16:00'),
       (1, '(555)765-1670', 'Goomba Family Medicine', '8:00', '16:00'),
       (1, '(999)567-2006', 'Larryville Physicians Network', '8:00', '16:00'),
       (1, '(888)510-5504', 'DevMed Health Office', '8:00', '16:00'),
       (1, '(677)543-0994', 'Patient First Family Practice', '8:00', '16:00');

INSERT INTO appointment_schedule(
	doctor_id, patient_id, appointment_date, time_block_id, office_id, appointment_reason_id, appointment_status_id, schedule_status_id)
	VALUES (3, 0, '2024-01-15', 33, 1, 1, 1, 1),
		   (3, 0, '2024-01-15', 36, 1, 1, 1, 1),
		   (3, 0, '2024-01-15', 39, 1, 1, 1, 1),
		   (3, 0, '2024-01-15', 42, 1, 1, 1, 1),
		   (3, 0, '2024-01-15', 45, 1, 1, 1, 1),
		   (3, 0, '2024-01-15', 48, 1, 1, 1, 3),
		   (3, 0, '2024-01-15', 49, 1, 1, 1, 2),
		   (3, 0, '2024-01-15', 53, 1, 1, 1, 1),
		   (3, 0, '2024-01-15', 56, 1, 1, 1, 1),
		   (3, 0, '2024-01-15', 59, 1, 1, 1, 1),
		   (3, 0, '2024-01-15', 62, 1, 1, 1, 1);


INSERT INTO doctor_office(doctor_id, office_id)
VALUES (1, 1),
       (3, 1),
       (3, 3);

-- INSERT INTO table_name(column1, 2, 3, etc.)
-- VALUES (a, b, c, d)


COMMIT TRANSACTION;
