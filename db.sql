CREATE DATABASE Hospital_Management;

Use  Hospital_Management;

CREATE TABLE Admin (
    a_id int primary key AUTO_INCREMENT,
    a_firstName varchar(30) ,
    a_lastName varchar(30),
    a_email varchar(30),
    a_password varchar(600),
    a_contact varchar(30)
);


CREATE TABLE Department (
    dept_id int primary key AUTO_INCREMENT,
    dept_name varchar(150)
);



CREATE TABLE Doctor (
    d_id int primary key AUTO_INCREMENT,
    d_firstName varchar(30),
    d_lastName varchar(30),
    d_email varchar(30),
    d_password varchar(600),
    d_contact varchar(30),
    d_qualification varchar (200),
    d_status int ,
    d_address varchar(400),
    d_dob date,
    d_gender varchar(30),
    dept_id int,
    FOREIGN KEY (dept_id) REFERENCES Department(dept_id) 

);


CREATE TABLE Patient (
    p_id int primary key AUTO_INCREMENT,
    p_firstName varchar(20),
    p_lastName varchar(20),
     p_email varchar(30),
    p_password varchar(600),
    p_contact varchar(30),
    p_gender varchar(30),
    p_dob date,
    p_bloodGroup varchar(30),
    p_address varchar(400)
   
 

);

CREATE TABLE Appointment (
    ap_id int primary key AUTO_INCREMENT,
    p_id int,
       FOREIGN KEY (p_id) REFERENCES Patient(p_id),
     ap_date date,
     ap_time time,
      p_admitStatus int,
    p_ap_status int, 
     ap_reason varchar(500),
        d_id int ,
   FOREIGN KEY (d_id) REFERENCES Doctor(d_id)  
     

);

CREATE TABLE Room (
    room_id int primary key ,
    room_type varchar(30),
    room_rate double,
    room_status int,
    p_id int,
    FOREIGN KEY (p_id) REFERENCES Patient(p_id)
    
);

CREATE TABLE Bill (
    
    bill_id int primary key AUTO_INCREMENT,

    
    ap_id int,
 FOREIGN KEY (ap_id) REFERENCES Appointment(ap_id),
 doctor_fees double,
 room_duration int,
  room_id int,
   FOREIGN KEY (room_id) REFERENCES Room(room_id)



);






CREATE TABLE Prescription (
    prc_id int primary key AUTO_INCREMENT,
    prc_date date,
     p_id int,
    FOREIGN KEY (p_id) REFERENCES Patient(p_id),
     medicines varchar(6000),
     fees double

);
















