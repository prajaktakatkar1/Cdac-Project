--departments (hard coded)
/* ENT
gynaecology
 dental
neurology
plastic surgery
Radiology */


- Admin
INSERT into admin values (default,'vidita', 'pathak' , 'pathakvidita999@gmail.com' , '$2a$10$fvaI2KE7qPQv3YVvIjIPGesiOyAEE4UKnUXcGRhc82mWPqbDodUYu','123456789', null );

INSERT into admin values (default,'rakshit', 'sharma' , 'rakshit@gmail.com' , '$2a$10$fvaI2KE7qPQv3YVvIjIPGesiOyAEE4UKnUXcGRhc82mWPqbDodUYu','123456789', null );

INSERT into admin values (default,'salil', 'joshi' , 'salilsj1619@gmail.com' , '$2a$10$fvaI2KE7qPQv3YVvIjIPGesiOyAEE4UKnUXcGRhc82mWPqbDodUYu','123456789', null );

INSERT into admin values (default,'rashmi', 'sinha' , 'rashmisinha2601@gmail.com' , '$2a$10$fvaI2KE7qPQv3YVvIjIPGesiOyAEE4UKnUXcGRhc82mWPqbDodUYu','1234565544', null );

INSERT into admin values (default,'rashmi', 'rashmi@gmail.com' , 'rashmi','123456700' );


-- department

Insert into department values (1 , 'neurology');

Insert into department values (2 , 'cardiology');

Insert into department values (3 , 'ent');
Insert into department values ( 4, 'orthology');
Insert into department values ( 5, 'dental');
Insert into department values ( 6, 'radiology');



-- Doctor

INSERT INTO doctor values (default , 'salil' , 'joshi' , '2020-10-10', 'salil@gmail.com' , '$2a$10$NcpjErIYm1vlIMBjEA4ts.NBB51gUqtjyTEQsoDPa3oyl7rKTWw2O' , '123456789' , 'mbbs' , 1 , 'Uttarakhand' , '1999-10-10' , 'male' , 1 , null);


INSERT INTO doctor values (default , 'mahesh' , 'ghule' , '2020-10-10', 'salil@gmail.com' , '$2a$10$NcpjErIYm1vlIMBjEA4ts.NBB51gUqtjyTEQsoDPa3oyl7rKTWw2O' , '123456789' , 'mbbs' ,  0, 'Uttarakhand' , '1999-10-10' , 'male' , 1 , null);

INSERT INTO doctor values (default , 'pratyant' , 'sootha' , '2019-5-10', 'sootha@gmail.com' , '$2a$10$NcpjErIYm1vlIMBjEA4ts.NBB51gUqtjyTEQsoDPa3oyl7rKTWw2O' , '123456789' , 'mbbs' , 1 , 'Uttarakhand' , '1999-10-10' , 'male' , 2 );

INSERT INTO doctor values (default , 'abc' , 'def' , '2020-10-10', 'salil@gmail.com' , '$2a$10$NcpjErIYm1vlIMBjEA4ts.NBB51gUqtjyTEQsoDPa3oyl7rKTWw2O' , '123456789' , 'mbbs' , 1 , 'Uttarakhand' , '1999-10-10' , 'male' , 1 );
INSERT INTO doctor values (default , 'sumit ' , 'oli' ,  '2018-1-1' , 'prajakta@gmail.com' , 'prajakta' , '123456789' , 'mbbs' , 1 , 'pune' , '1999-10-10' , 'female' , 2 );


INSERT INTO doctor values (default , 'ayush'  , 'sarwalia' , 'ayush@gmail.com' , 'prashant' , '123456789' , 'mbbs' , 2 , 'delhi' , '1999-10-10' , 'male' , 1 );




-- patient


INSERT into patient values (default , 'prashant' , 'bhatt', 'prashant@gmail.com' , '$2a$10$wLhCkABQgTqhO6WvSQeZdO98vngLdaLcwv2k821stfQOGh3LJ3YW6' , '123456999' , 'female' , '2000-10-10' , 'o+'  , 'pune' , null );

INSERT into patient values (default , 'deepak' , 'bhatt', 'deepak@gmail.com' , '$2a$10$wLhCkABQgTqhO6WvSQeZdO98vngLdaLcwv2k821stfQOGh3LJ3YW6' , '123456999' , 'female' , '2005-10-10' , 'o+'  , 'pune' , null );

INSERT into patient values (default , '' , 'sonia@gmail.com' , 'sonia' , '123456889' , 'female' , '2000-10-10' , 'o+'  , 'mumbai'  );

INSERT into patient values (default , 'rajeev' , 'sonia@gmail.com' , 'sonia' , '123456889' , 'female' , '2000-10-10' , 'o+'  , 'mumbai' );

INSERT into patient values (default , 'nilesh' , 'sonia@gmail.com' , 'sonia' , '123456889' , 'female' , '2000-10-10' , 'o+'  , 'mumbai'  );

INSERT into patient values (default , 'amar' , 'amar@gmail.com' , 'amar' , '123456339' , 'male' , '2000-10-14' , 'o+'  , 'goa' );


-- Appointment:

INSERT INTO Appointment values(default , 1 , '1999-10-10' , '19:30:10' , 1 , 1 , 'ill' , 2);

INSERT INTO Appointment values(default , 5 , '1999-10-10' , '19:30:10' , 1 , 1 , 'ill' , 2);


INSERT INTO Appointment values(default , 6 , '2000-10-10' , '13:30:10' , 1 , 1 , 'fever', 2);


-- room
INSERT INTO Appointment values(default , 1 , '1999-10-10' , '19:30:10' , 1 , 1 , 'ill' , 2);

INSERT INTO ROOM values(102 , 'non -ac' , 1000 , 1 , 1  );

INSERT INTO ROOM values(103, 'non -ac' , 1000 , 0 , null  );



--bill

INSERT into bill values(default , 6, 500, 2 , 102);



-- prescription
INSERT into prescription values(default , '1999-10-10' , 1 , 'paracetamol' , 100); 

---------------------------------------
--JOINS
----------------------------------------

select * from appointment where p_id = 5;



-- ROugh 

Select d.dept_name , d1.d_name from department d Inner join doctor d1 ON d1.dept_id= d.dept_id; 

SELECT * from bill where p_id =5;

SELECT p.p_name ,  a.ap_date , b.bill_id  from patient p inner join appointment a ON p.p_id = a.ap_id INNER JOIN bill b ON b.p_id = p.p_id;

SELECT p.p_name ,  a.ap_date , b.bill_id  from patient p inner join appointment a ON p.p_id = a.ap_id 

-- Find patient name , his appoinment date  , his bill

SELECT p.p_name , a.ap_date ,  b.doctor_fees from patient p INNER JOIN appoinment a ON p.p_id = a.p_id INNER JOIN bill b ON p.p_id = b.p_id;

INSERT INTO bill values(default , 6 , 2 , 600 , 3 , 4);


INSERT INTO Appointment VALUES ( default , 5 , '2020-10-10' , '20:30:10',  1 , 1 , "headache" , 4);
INSERT INTO Appointment values(default , 6 , '2000-10-10' , '13:30:10' , 1 , 1 , 'fever', 2);


SELECT * FROM BILL where p_id = 5;

INSERT into bill values(default , 5, 7 , 300, 1 , 4);

patient id , patient name and bill  appointment id 

select b.* , p.p_name , a.ap_id FROM bill b INNER JOIN  appointment a ON b.ap_id = a.ap_id INNER JOIN patient p ON a.p_id = p.p_id;


INSERT into bill values(default , 2, 500, 2 , 101);
INSERT into bill values(default , 1, 500, 2 , 102);
