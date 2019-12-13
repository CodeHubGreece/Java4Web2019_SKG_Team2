CREATE DATABASE EFKA CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE EFKA;

DROP TABLE IF EXISTS appointments;
DROP TABLE IF EXISTS citizens;
DROP TABLE IF EXISTS doctors;
DROP TABLE IF EXISTS specialties;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
id bigint auto_increment,
username varchar(50) NOT NULL,
`password` varchar(50) NOT NULL,
`type` char(1) NOT NULL,
PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE citizens (
amka varchar(11) NOT NULL,
last_name varchar(50) NOT NULL,
first_name varchar(50) NOT NULL,
phone varchar(10) NOT NULL,
email varchar(50) NOT NULL,
user_id bigint NOT NULL UNIQUE,
PRIMARY KEY (AMKA),
FOREIGN KEY (user_id) REFERENCES users (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE specialties (
specialty_id int auto_increment NOT NULL,
specialty varchar(50) NOT NULL,
PRIMARY KEY (specialty_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE doctors (
doctor_id varchar(5) NOT NULL,
last_name varchar(50) NOT NULL,
first_name varchar(50) NOT NULL,
specialty_id int NOT NULL,
user_id bigint NOT NULL UNIQUE,
PRIMARY KEY (doctor_id),
FOREIGN KEY (user_id) REFERENCES users (id),
FOREIGN KEY (specialty_id) REFERENCES specialties (specialty_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE appointments (
appointment_id bigint auto_increment,
amka_c varchar(11) NOT NULL,
doctor_id varchar(5) NOT NULL,
`date` DATE  NOT NULL,
`time` time NOT NULL,
illness_description varchar(50) NOT NULL,
comments varchar(200),
PRIMARY KEY (appointment_id),
FOREIGN KEY (amka_c) REFERENCES citizens (amka),
FOREIGN KEY (doctor_id) REFERENCES doctors (doctor_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;