BEGIN TRANSACTION;

-- Doctor Specialty Metadata Insert Statement --

INSERT INTO specialty(specialty_name)
VALUES ('Internal Medicine'), ('Surgery'), ('General Surgery'), ('Pediatrics'),
       ('Family Medicine'), ('Dermatology'), ('Anesthesiology'), ('Emergency Medicine'),
       ('Obsterics & Gynaecology'), ('Neurology'), ('Psychiatry'), ('Pathology'),
       ('Physical Therapy'), ('Urology'), ('Immunology'),('Oncology'),
       ('Radiology'), ('Opthalmology'), ('Preventive Healthcare'), ('Nuclear Medicine'),
       ('Medical Genetics'), ('Orthopeics'), ('Otorhinolaryngology'), ('Cardiology'),
       ('Plastic Surgery'), ('Diagnostic Radiology'), ('Pain Management'), ('Gastroenterology'),
       ('Cardiothoracic Surgery'), ('Endocrinology'), ('Nephrology'), ('Geriatrics'), ('Rheumatology'),
       ('Neurosurgery'), ('Pulmonology'), ('Intensive Care Medicine'), ('Hospital Medicine'),
       ('Hematology'), ('Forensic Pathology'), ('Occupational Medicine'), ('Biochemistry'), ('Spinal Cord Injury Medicine'),
       ('Brain Injury Medicine'), ('Pediatric Anesthesiology'), ('Clinical Pathology'), ('Medical Microbiology'),
       ('Allergy & Immunology'), ('Anatomical Pathology'), ('Colorectal Surgery'), ('Vascular Surgery'),
       ('Pediatric Hematology'), ('Pediatric Hematology Oncology');

-- Time Block Metadata Insert Statements --

INSERT INTO time_block (start_time) VALUES ('0:00');
INSERT INTO time_block (start_time) VALUES ('0:15');
INSERT INTO time_block (start_time) VALUES ('0:30');
INSERT INTO time_block (start_time) VALUES ('0:45');
INSERT INTO time_block (start_time) VALUES ('1:00');
INSERT INTO time_block (start_time) VALUES ('1:15');
INSERT INTO time_block (start_time) VALUES ('1:30');
INSERT INTO time_block (start_time) VALUES ('1:45');
INSERT INTO time_block (start_time) VALUES ('2:00');
INSERT INTO time_block (start_time) VALUES ('2:15');
INSERT INTO time_block (start_time) VALUES ('2:30');
INSERT INTO time_block (start_time) VALUES ('2:45');
INSERT INTO time_block (start_time) VALUES ('3:00');
INSERT INTO time_block (start_time) VALUES ('3:15');
INSERT INTO time_block (start_time) VALUES ('3:30');
INSERT INTO time_block (start_time) VALUES ('3:45');
INSERT INTO time_block (start_time) VALUES ('4:00');
INSERT INTO time_block (start_time) VALUES ('4:15');
INSERT INTO time_block (start_time) VALUES ('4:30');
INSERT INTO time_block (start_time) VALUES ('4:45');
INSERT INTO time_block (start_time) VALUES ('5:00');
INSERT INTO time_block (start_time) VALUES ('5:15');
INSERT INTO time_block (start_time) VALUES ('5:30');
INSERT INTO time_block (start_time) VALUES ('5:45');
INSERT INTO time_block (start_time) VALUES ('6:00');
INSERT INTO time_block (start_time) VALUES ('6:15');
INSERT INTO time_block (start_time) VALUES ('6:30');
INSERT INTO time_block (start_time) VALUES ('6:45');
INSERT INTO time_block (start_time) VALUES ('7:00');
INSERT INTO time_block (start_time) VALUES ('7:15');
INSERT INTO time_block (start_time) VALUES ('7:30');
INSERT INTO time_block (start_time) VALUES ('7:45');
INSERT INTO time_block (start_time) VALUES ('8:00');
INSERT INTO time_block (start_time) VALUES ('8:15');
INSERT INTO time_block (start_time) VALUES ('8:30');
INSERT INTO time_block (start_time) VALUES ('8:45');
INSERT INTO time_block (start_time) VALUES ('9:00');
INSERT INTO time_block (start_time) VALUES ('9:15');
INSERT INTO time_block (start_time) VALUES ('9:30');
INSERT INTO time_block (start_time) VALUES ('9:45');
INSERT INTO time_block (start_time) VALUES ('10:00');
INSERT INTO time_block (start_time) VALUES ('10:15');
INSERT INTO time_block (start_time) VALUES ('10:30');
INSERT INTO time_block (start_time) VALUES ('10:45');
INSERT INTO time_block (start_time) VALUES ('11:00');
INSERT INTO time_block (start_time) VALUES ('11:15');
INSERT INTO time_block (start_time) VALUES ('11:30');
INSERT INTO time_block (start_time) VALUES ('11:45');
INSERT INTO time_block (start_time) VALUES ('12:00');
INSERT INTO time_block (start_time) VALUES ('12:15');
INSERT INTO time_block (start_time) VALUES ('12:30');
INSERT INTO time_block (start_time) VALUES ('12:45');
INSERT INTO time_block (start_time) VALUES ('13:00');
INSERT INTO time_block (start_time) VALUES ('13:15');
INSERT INTO time_block (start_time) VALUES ('13:30');
INSERT INTO time_block (start_time) VALUES ('13:45');
INSERT INTO time_block (start_time) VALUES ('14:00');
INSERT INTO time_block (start_time) VALUES ('14:15');
INSERT INTO time_block (start_time) VALUES ('14:30');
INSERT INTO time_block (start_time) VALUES ('14:45');
INSERT INTO time_block (start_time) VALUES ('15:00');
INSERT INTO time_block (start_time) VALUES ('15:15');
INSERT INTO time_block (start_time) VALUES ('15:30');
INSERT INTO time_block (start_time) VALUES ('15:45');
INSERT INTO time_block (start_time) VALUES ('16:00');
INSERT INTO time_block (start_time) VALUES ('16:15');
INSERT INTO time_block (start_time) VALUES ('16:30');
INSERT INTO time_block (start_time) VALUES ('16:45');
INSERT INTO time_block (start_time) VALUES ('17:00');
INSERT INTO time_block (start_time) VALUES ('17:15');
INSERT INTO time_block (start_time) VALUES ('17:30');
INSERT INTO time_block (start_time) VALUES ('17:45');
INSERT INTO time_block (start_time) VALUES ('18:00');
INSERT INTO time_block (start_time) VALUES ('18:15');
INSERT INTO time_block (start_time) VALUES ('18:30');
INSERT INTO time_block (start_time) VALUES ('18:45');
INSERT INTO time_block (start_time) VALUES ('19:00');
INSERT INTO time_block (start_time) VALUES ('19:15');
INSERT INTO time_block (start_time) VALUES ('19:30');
INSERT INTO time_block (start_time) VALUES ('19:45');
INSERT INTO time_block (start_time) VALUES ('20:00');
INSERT INTO time_block (start_time) VALUES ('20:15');
INSERT INTO time_block (start_time) VALUES ('20:30');
INSERT INTO time_block (start_time) VALUES ('20:45');
INSERT INTO time_block (start_time) VALUES ('21:00');
INSERT INTO time_block (start_time) VALUES ('21:15');
INSERT INTO time_block (start_time) VALUES ('21:30');
INSERT INTO time_block (start_time) VALUES ('21:45');
INSERT INTO time_block (start_time) VALUES ('22:00');
INSERT INTO time_block (start_time) VALUES ('22:15');
INSERT INTO time_block (start_time) VALUES ('22:30');
INSERT INTO time_block (start_time) VALUES ('22:45');
INSERT INTO time_block (start_time) VALUES ('23:00');
INSERT INTO time_block (start_time) VALUES ('23:15');
INSERT INTO time_block (start_time) VALUES ('23:30');
INSERT INTO time_block (start_time) VALUES ('23:45');

-- Appointment Reason Metadata Insert Statements --

INSERT INTO appointment_reason (reason) VALUES ('New Problem');
INSERT INTO appointment_reason (reason) VALUES ('Follow-Up');
INSERT INTO appointment_reason (reason) VALUES ('Annual Wellness (Adult)');
INSERT INTO appointment_reason (reason) VALUES ('Women''s Annual Wellness');
INSERT INTO appointment_reason (reason) VALUES ('Well Child Visit');
INSERT INTO appointment_reason (reason) VALUES ('Ill Child Visit');
INSERT INTO appointment_reason (reason) VALUES ('Annual Medicare Wellness');
INSERT INTO appointment_reason (reason) VALUES ('Annual Mammogram');

-- Appointment Status Metadata Insert Statements --

INSERT INTO appointment_status (status) VALUES ('Scheduled');
INSERT INTO appointment_status (status) VALUES ('Rescheduled');
INSERT INTO appointment_status (status) VALUES ('Canceled');
INSERT INTO appointment_status (status) VALUES ('Completed');

-- Phone Type Metadata Insert Statements --

INSERT INTO phone_type (phone_type) VALUES ('Primary');
INSERT INTO phone_type (phone_type) VALUES ('Mobile');
INSERT INTO phone_type (phone_type) VALUES ('Secondary');
INSERT INTO phone_type (phone_type) VALUES ('Land-Line');



COMMIT TRANSACTION;
