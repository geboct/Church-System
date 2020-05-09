CREATE DATABASE IF NOT EXISTS churchsystem;
USE churchsystem;


CREATE TABLE IF NOT EXISTS admin(
user_id INT PRIMARY KEY,
username VARCHAR (255) NOT NULL ,
first_name VARCHAR (255) NOT NULL ,
middle_name VARCHAR (255),
surname VARCHAR (255) NOT NULL ,
dob DATE ,
phone VARCHAR (255) NOT NULL ,
e_mail VARCHAR (255),
role VARCHAR (255) NOT NULL,
date_added  TIMESTAMP DEFAULT CURRENT_TIMESTAMP

)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS members(
user_id INT PRIMARY KEY,
username VARCHAR (255) NOT NULL ,
first_name VARCHAR (255) NOT NULL ,
middle_name VARCHAR (255),
surname VARCHAR (255) NOT NULL ,
dob DATE ,
phone VARCHAR (255),
e_mail VARCHAR (255),
role VARCHAR (255) NOT NULL,
image MEDIUMBLOB NOT NULL ,
date_added  TIMESTAMP DEFAULT CURRENT_TIMESTAMP

)ENGINE=INNODB;