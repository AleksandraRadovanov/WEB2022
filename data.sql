
INSERT INTO KORISNIK(korisnickoIme, lozinka, ime, prezime, pol, datumRodjenja, uloga) values
	('MilanRadovanov', 'admin123', 'Milan', 'Radovanov', 'm', '4/3/1969', 'ADMIN'),
	('NikolaJokic', 'mvp2', 'Luka', 'Andric', 'm', '25/10/2000', 'MENADZER'),
	('Filip', '123abc', 'Filip', 'Mrdjanovic', 'm', '12/10/2000', 'DOSTAVLJAC'),
	('Plavsic', 'kupac123', 'Dusan', 'Plavsic', 'm', '24/11/2000', 'KUPAC');
	
INSERT INTO MENADZER(id) SELECT ID FROM KORISNIK WHERE uloga = 'MENADZER';
UPDATE MENADZER SET restoranid = 16;

INSERT INTO ARTIKAL(naziv, cena, tip, kolicina, opis) VALUES
	('Weekend Specijal', 750, 'HRANA', 16, 'Grilovane suve sljive u slanini, raclette sir, demiglace sos, kiseli ljubicasti luk, mix zelenih salata'),
	('Toster dorucak', 360, 'HRANA', 40, 'Dva jaja, slanina, sir, salata, sos, lepinja'),
	('Coca cola 0.5l', 190, 'PICE', 134, 'Osvezavajuuce bezalkoholno gazirano pice'),
	('Schneider Trap 7 0.5l', 400, 'PICE', 43, 'Osvezavajuce svetlo alkoholno pice'),
	('Voda Rosa 0.33l', 160, 'PICE', 220, 'Hladna osvezavajuca izvorska voda' );
	
INSERT INTO RESTORAN(naziv, tip, )

INSERT INTO FITNESS (name, address, central_number, email) VALUES
    ('FITNESS CENTRE I', 'Bulevar Kralja Petra I 1', '9876543210', 'fitnessI.centre@centre.com'),
    ('FITNESS CENTRE II', 'Bulevar Kralja Petra I 5', '0123456789', 'fitnessII.centre@centre.com'),
    ('FITNESS CENTRE III', 'Bulevar Kralja Petra I 16', '9874563210', 'fitnessIII.centre@centre.com'),
    ('FITNESS CENTRE IV', 'Bulevar Kralja Petra I 25', '9874561230', 'fitnessIV.centre@centre.com'),
    ('FITNESS CENTRE V', 'Bulevar Kralja Petra I 57', '7894561230', 'fitnessV.centre@centre.com'),

INSERT INTO TRAINER(id) SELECT ID FROM USER WHERE role='TRAINER';

UPDATE TRAINER SET grade = 5;
UPDATE TRAINER SET is_allowed = true;
UPDATE TRAINER SET is_allowed = false LIMIT 16;
UPDATE TRAINER SET is_allowed = true LIMIT 1;

--UPDATE TRAINER SET fitness_id = SELECT ID from FITNESS LIMIT 1;

INSERT INTO MEMBER(id) SELECT ID FROM USER WHERE role='MEMBER';

INSERT INTO ADMINISTRATOR(id) SELECT ID FROM USER WHERE role='ADMIN';

insert into TRAINING (name, description, type, duration) values
	('Lunges', 'consequat in consequat ut nulla sed accumsan', 'Cardio', 49),
	('Dumbbell rows', 'mi in porttitor pede justo eu massa', 'Cardio', 40),
	('Pushups', 'donec ut mauris eget massa tempor convallis', 'Cardio', 45),
	('Squats', 'eu interdum eu tincidunt in leo', 'Weight loss', 86),
	('Single-leg deadlifts', 'quam a odio in hac', 'Crossfit', 46),
	('Overhead dumbbell presses', 'interdum mauris non ligula pellentesque ultrices phasellus', 'Yoga', 44),
	('Lunges', 'eu tincidunt in leo maecenas', 'Yoga', 44),
	('Overhead dumbbell presses', 'morbi porttitor lorem id ligula', 'Yoga', 56),
	('Pushups', 'augue vel accumsan tellus nisi eu orci', 'Endurence', 87),
	('Squats', 'odio condimentum id luctus nec molestie', 'Cardio', 95),
	('Dumbbell rows', 'ipsum primis in faucibus orci luctus et', 'Cardio', 54),
	('Burpees', 'vestibulum rutrum rutrum neque aenean', 'Endurence', 78),
	('Overhead dumbbell presses', 'nunc commodo placerat praesent blandit', 'Yoga', 55),
	('Burpees', 'platea dictumst maecenas ut massa', 'Weight loss', 40);


INSERT INTO HALL (capacity, fitness_id) VALUES (50, 1), (60, 4), (50, 3), (50, 1), (50, 2);
INSERT INTO HALL (capacity) VALUES (50), (60), (50), (50), (50),(50), (60), (50), (50), (50),(50), (60), (50), (50), (50),(50), (60), (50), (50), (50),(50), (60), (50), (50), (50);

insert into APPOINTMENT (date, price) values
('2/17/2021', 254),('1/7/2021', 854),('11/5/2020', 354),('2/27/2021', 254),('12/8/2020', 754),('3/16/2021', 965),('5/21/2021', 124),
('3/26/2021', 965),('8/1/2020', 152),('5/14/2021', 451),('10/28/2020', 854),('11/26/2020', 352),('1/9/2021', 458),('5/31/2021', 100),
('12/27/2020', 521),('8/27/2020', 352),('10/14/2020', 624)('8/9/2020', 325),('5/19/2021', 654),('8/21/2020', 271),('8/17/2020', 352),
('3/9/2021', 541),('8/24/2020', 452),('7/10/2020', 541),('7/22/2020', 324),('8/7/2020', 543),('7/3/2021', 254),('11/22/2020', 451),
('5/5/2021', 241),('3/27/2021', 325),('8/24/2020', 451),('1/15/2021', 321),('8/11/2020', 421),('10/2/2020', 251);


INSERT INTO GRADE(grade, appointment_id, member_id) VALUES
    (4, (SELECT ID from APPOINTMENT LIMIT 1), (SELECT ID from MEMBER LIMIT 1)),
    (5, (SELECT ID from APPOINTMENT LIMIT 1), (SELECT ID from MEMBER LIMIT 1)),
    (3, (SELECT ID from APPOINTMENT LIMIT 1), (SELECT ID from MEMBER LIMIT 1));

INSERT INTO ASSIGNED(member_id, appointment_id) VALUES ((SELECT ID from MEMBER LIMIT 1), (SELECT ID from APPOINTMENT LIMIT 1));

INSERT INTO COMPLETED (member_id, appointment_id) VALUES ((SELECT ID from MEMBER LIMIT 1), (SELECT ID from APPOINTMENT LIMIT 1));
INSERT INTO COMPLETED (member_id, appointment_id) VALUES ((SELECT ID from MEMBER LIMIT 1 OFFSET 1), (SELECT ID from APPOINTMENT LIMIT 1 OFFSET 1));
INSERT INTO COMPLETED (member_id, appointment_id) VALUES ((SELECT ID from MEMBER LIMIT 1 OFFSET 2), (SELECT ID from APPOINTMENT LIMIT 1 OFFSET 2));
INSERT INTO COMPLETED (member_id, appointment_id) VALUES ((SELECT ID from MEMBER LIMIT 1 OFFSET 3), (SELECT ID from APPOINTMENT LIMIT 1 OFFSET 3));
INSERT INTO COMPLETED (member_id, appointment_id) VALUES ((SELECT ID from MEMBER LIMIT 1 OFFSET 4), (SELECT ID from APPOINTMENT LIMIT 1 OFFSET 4));
INSERT INTO COMPLETED (member_id, appointment_id) VALUES ((SELECT ID from MEMBER LIMIT 1 OFFSET 5), (SELECT ID from APPOINTMENT LIMIT 1 OFFSET 5));
INSERT INTO COMPLETED (member_id, appointment_id) VALUES ((SELECT ID from MEMBER LIMIT 1 OFFSET 6), (SELECT ID from APPOINTMENT LIMIT 1 OFFSET 6));
INSERT INTO COMPLETED (member_id, appointment_id) VALUES ((SELECT ID from MEMBER LIMIT 1 OFFSET 10), (SELECT ID from APPOINTMENT LIMIT 1 OFFSET 10));
INSERT INTO COMPLETED (member_id, appointment_id) VALUES ((SELECT ID from MEMBER LIMIT 1 OFFSET 11), (SELECT ID from APPOINTMENT LIMIT 1 OFFSET 11));
INSERT INTO COMPLETED (member_id, appointment_id) VALUES ((SELECT ID from MEMBER LIMIT 1 OFFSET 12), (SELECT ID from APPOINTMENT LIMIT 1 OFFSET 12));
INSERT INTO COMPLETED (member_id, appointment_id) VALUES ((SELECT ID from MEMBER LIMIT 1 OFFSET 15), (SELECT ID from APPOINTMENT LIMIT 1 OFFSET 15));

