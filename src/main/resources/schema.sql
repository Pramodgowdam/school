create table school(
  ID int not null AUTO_INCREMENT,
  name varchar(100) not null,
  date_of_birth date,
  joining_date date,
  class varchar(100) not null,
  PRIMARY KEY ( ID )
);