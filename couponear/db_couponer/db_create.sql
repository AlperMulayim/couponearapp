-- Active: 1651576140687@@127.0.0.1@3306
CREATE DATABASE couponeardb
    DEFAULT CHARACTER SET = 'utf8mb4';

CREATE TABLE cpdb_users(
    id  INT NOT NULL AUTO_INCREMENT,
    user_uid VARCHAR(65),
    first_name VARCHAR(65),
    surname VARCHAR(65),
    mail VARCHAR(65),
    PRIMARY KEY(id)
);

create table cpdb_companies (
	id INT NOT NULL AUTO_INCREMENT,
	company_name VARCHAR(50),
	owner_id VARCHAR(1),
	address VARCHAR(50),
	city VARCHAR(50),
	mail VARCHAR(50),
	phone VARCHAR(50),
    PRIMARY KEY(id)
);