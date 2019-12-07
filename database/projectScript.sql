CREATE DATABASE EFKA CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE EFKA;

DROP TABLE IF EXISTS appointment;
DROP TABLE IF EXISTS specialties;
DROP TABLE IF EXISTS citizen;
DROP TABLE IF EXISTS doctor;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
id int auto_increment,
username varchar(50) NOT NULL,
`password` varchar(50) NOT NULL,
`type` varchar(1) NOT NULL,
PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE citizen (
AMKA varchar(11) NOT NULL,
last_name varchar(50) NOT NULL,
first_name varchar(50) NOT NULL,
phone varchar(10) NOT NULL,
email varchar(50) NOT NULL,
user_id int,
PRIMARY KEY (AMKA),
FOREIGN KEY (user_id) REFERENCES users (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE specialties (
specialty_id int auto_increment,
specialty varchar(50),
PRIMARY KEY (specialty_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE doctor (
doctor_id varchar(5) NOT NULL,
last_name varchar(50) NOT NULL,
first_name varchar(50) NOT NULL,
specialty int,
user_id int,
PRIMARY KEY (doctor_id),
FOREIGN KEY (user_id) REFERENCES users (id),
FOREIGN KEY (specialty) REFERENCES specialties (specialty_id)
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
FOREIGN KEY (doctor_id) REFERENCES doctor (doctor_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
