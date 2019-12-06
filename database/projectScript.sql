CREATE DATABASE EFKA CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE EFKA;

DROP TABLE IF EXISTS appointment;
DROP TABLE IF EXISTS citizen;
DROP TABLE IF EXISTS doctor;

CREATE TABLE citizen (
AMKA varchar(11) NOT NULL,
last_name varchar(50) NOT NULL,
first_name varchar(50) NOT NULL,
phone varchar(10) NOT NULL,
email varchar(50) NOT NULL,
username varchar(50) NOT NULL,
`password` varchar(50) NOT NULL,
PRIMARY KEY (AMKA)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE doctor (
id varchar(5) NOT NULL,
last_name varchar(50) NOT NULL,
first_name varchar(50) NOT NULL,
specialty varchar(50) NOT NULL,
username varchar(50) NOT NULL,
`password` varchar(50) NOT NULL,
PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE appointment (
appointmentID int auto_increment, #gia na kanei monadiko arithmo apo mono tou #
AMKA_C varchar(11) NOT NULL,
doctor_id varchar(5) NOT NULL,
`time` time NOT NULL,
`date` DATE  NOT NULL,
illness_description varchar(50) NOT NULL,
comments varchar(200) NOT NULL,
PRIMARY KEY (appointmentID),
FOREIGN KEY (AMKA_C) REFERENCES citizen (AMKA),
FOREIGN KEY (doctor_id) REFERENCES doctor (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

