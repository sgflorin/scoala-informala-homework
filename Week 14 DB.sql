create database schooldb;

use schooldb;

CREATE TABLE `classes` (
	classid INT NOT NULL,
	courseid VARCHAR(64) NOT NULL,
	days INT NOT NULL,
	starttime DATE NOT NULL,
	endtime DATE NOT NULL,
	building VARCHAR(64) NOT NULL,
	roomnum INT NOT NULL,
	PRIMARY KEY (courseid)
);

CREATE TABLE `courses` (
	courseid VARCHAR(64) NOT NULL,
	area VARCHAR(64) NOT NULL,
	title VARCHAR(64) NOT NULL,
	descrip VARCHAR(255),
	prereqs VARCHAR(255),
    PRIMARY KEY (title),
	foreign key(courseid) references `classes`(courseid)
);

CREATE TABLE `crosslistings` (
	courseid VARCHAR(64) NOT NULL,
	dept VARCHAR(64) NOT NULL,
	coursenum INT NOT NULL,
	foreign key(courseid) references courses(courseid) 
);

CREATE TABLE `coursesprofs` (
	courseid VARCHAR(64) NOT NULL,
	profid INT NOT NULL,
    primary key (profid),
    foreign key(courseid) references courses(courseid)
);

CREATE TABLE `profs` (
	profid INT NOT NULL,
	profname VARCHAR(128) NOT NULL,
	foreign key(profid) references coursesprofs(profid)
);

insert into `classes` values (1, "MATH101", 90, "2019-09-15", "2019-12-15", "Building A", 20);
insert into `classes` values (2, "CHEM101", 90, "2019-09-15", "2019-12-15", "Building H", 9);
insert into `classes` values (3, "ENG101", 90, "2019-09-15", "2019-12-15", "Building C", 11);
insert into `classes` values (4, "GEO101", 120, "2019-09-15", "2020-01-15", "Building B", 2);
insert into `classes` values (5, "HIS101", 120, "2019-09-15", "2020-01-15", "Building A", 5);

insert into `courses` value ("MATH101", "cos", "Intro to Math", "nothing", "pen and paper");
insert into `courses` value ("CHEM101", "no idea", "Intro to Chemistry", "not drugs", "guts");
insert into `courses` value ("ENG101", "space", "English for beginners", "foreign words", "ears");
insert into `courses` value ("GEO101", "cos", "Where stuff is..", "basically Geoguesr", "map");
insert into `courses` value ("HIS101", "still no clue", "A Blast from the Past", "a list of dates", "memory");

insert into `crosslistings` values ("MATH101", "cos", 3);
insert into `crosslistings` values ("CHEM101", "fos", 2);
insert into `crosslistings` values ("ENG101", "hos", 1);
insert into `crosslistings` values ("GEO101", "cos", 6);
insert into `crosslistings` values ("HIS101", "aaaa", 8);

insert into `coursesprofs` values ("MATH101", 123);
insert into `coursesprofs` values ("CHEM101", 245);
insert into `coursesprofs` values ("ENG101", 129);
insert into `coursesprofs` values ("GEO101", 345);
insert into `coursesprofs` values ("HIS101", 251);

insert into `profs` values (123, "Cosguy McProf");
insert into `profs` values (245, "Heisenberg");
insert into `profs` values (129, "John Smith");
insert into `profs` values (345, "Jane Doe");
insert into `profs` values (251, "Alternius Phacts");


 