-- **************************************************************
-- This script creates "spoof" data for testing in the final_capstone database
-- **************************************************************

BEGIN TRANSACTION;

INSERT INTO specialty(specialty_name)
VALUES ('Internal Medicine'),
       ('Surgery'),
       ('General Surgery'),
       ('Pediatrics'),
       ('Family Medicine'),
       ('Dermatology'),
       ('Anesthesiology'),
       ('Emergency Medicine'),
       ('Obsterics & Gynaecology'),
       ('Neurology'),
       ('Psychiatry'),
       ('Pathology'),
       ('Physical Therapy'),
       ('Urology'),
       ('Immunology'),
       ('Oncology'),
       ('Radiology'),
       ('Opthalmology'),
       ('Preventive Healthcare'),
       ('Nuclear Medicine'),
       ('Medical Genetics'),
       ('Orthopeics'),
       ('Otorhinolaryngology'),
       ('Cardiology'),
       ('Plastic Surgery'),
       ('Diagnostic Radiology'),
       ('Pain Management'),
       ('Gastroenterology'),
       ('Cardiothoracic Surgery'),
       ('Endocrinology'),
       ('Nephrology'),
       ('Geriatrics'),
       ('Rheumatology'),
       ('Neurosurgery'),
       ('Pulmonology'),
       ('Intensive Care Medicine'),
       ('Hospital Medicine'),
       ('Hematology'),
       ('Forensic Pathology'),
       ('Occupational Medicine'),
       ('Biochemistry'),
       ('Spinal Cord Injury Medicine'),
       ('Brain Injury Medicine'),
       ('Pediatric Anesthesiology'),
       ('Clinical Pathology'),
       ('Medical Microbiology'),
       ('Allergy & Immunology'),
       ('Anatomical Pathology'),
       ('Colorectal Surgery'),
       ('Vascular Surgery'),
       ('Pediatric Hematology'),
       ('Pediatric Hematology Oncology');

INSERT INTO person(user_id, first_name, last_name, email, date_of_birth)
VALUES (1, 'Chachi', 'TheCat', 'chachicat@meowmeow.com', '2003-01-03'),
       (2, 'Joni', 'LovesChachi', 'joni@chachicat.net', '2005-01-23'),

INSERT INTO doctor(person_id, specialty_id, is_primary_care)
VALUES (1, 1, True),
       (2, 2, True),

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
