

-- -8<- [start:student]
drop table if exists STUDENT;
create table STUDENT(
	Id varchar(200) primary key,
	no varchar(20) unique  not null,
	name varchar(20) not null,
	gender varchar(2),
	age int,
	dept varchar(20)
);
-- -8<- [end:student]


-- -8<- [start:course]
drop table if exists COURSE;
create table COURSE(
	Id varchar(200) primary key,
	no varchar(20) unique  not null,
	name varchar(200) not null,
	PreNo varchar(20),
	credit numeric(10,      1)
);
-- -8<- [end:course]


-- -8<- [start:stucourse]
drop table if exists STUCOURSE;
create table STUCOURSE(
	Id varchar(200) primary key,
	CourseNo varchar(20) not null,
	StuNo varchar(20) not null,
	Grade numeric(10,1)
);
-- -8<- [end:stucourse]
