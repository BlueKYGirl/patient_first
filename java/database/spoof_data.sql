-- **************************************************************
-- This script creates "spoof" data for testing in the final_capstone database
-- **************************************************************

BEGIN TRANSACTION;

INSERT INTO users(username, password_hash, role)
VALUES ('CHAAAACHIIIII', 'er34289yh2uhg', 'ROLE_DOCTOR');

INSERT INTO specialty(specialty_name)
VALUES ('Endocrinologist');

INSERT INTO person(user_id, first_name, last_name, email, date_of_birth)
VALUES (1, 'Chachi', 'TheCat', 'chachicat@meowmeow.com', '2003-01-03');

INSERT INTO doctor(person_id, specialty_id, is_primary_care)
VALUES (1, 1, True);

INSERT INTO address(street_address, city, state_abbreviation, zip_code)
VALUES (420, 'CatTown', 'CT', 12345);

INSERT INTO phone_type(phone_type)
VALUES ('Primary');

INSERT INTO phone_number(phone_type_id, phone_number, is_primary_phone)
VALUES (1, '(123)456-7890', True);

INSERT INTO office(address_id, office_phone_number, practice_name, office_hours_start_time, office_hours_end_time)
VALUES (1, '(234)456-7890', 'Chachi & Associates', '8:00', '16:00');

INSERT INTO doctor_office(doctor_id, office_id)
VALUES (1, 1);




-- INSERT INTO table_name(column1, 2, 3, etc.)
-- VALUES (a, b, c, d)


COMMIT TRANSACTION;
