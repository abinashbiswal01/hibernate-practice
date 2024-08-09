--create table course (id int primary key, name varchar);
insert into course(id,name) values(1001,'SpringBoot');
insert into course(id,name) values(1002,'Hibernate');
insert into course(id,name) values(1003,'REST');

insert into student(id,name,passport_id) values(2001,'Rohit',4001);
insert into student(id,name,passport_id) values(2002,'Virat',4002);
insert into student(id,name,passport_id) values(2003,'Sky',4003);

insert into passport(id,number) values(4001,'S12345');
insert into passport(id,number) values(4002,'K98765');
insert into passport(id,number) values(4003,'Y67854');

insert into review(id,rating,description) values(5001,'5','Great Course');
insert into review(id,rating,description) values(5002,'4','Wonderful Course');
insert into review(id,rating,description) values(5003,'3','okay course');