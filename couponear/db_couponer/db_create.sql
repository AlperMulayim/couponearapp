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

create table cpdb_discount_cards (
	id INT,
	company_id INT,
	campaing_id INT,
	campaing_name VARCHAR(25),
	barcode VARCHAR(50),
	create_date DATE,
	expire_date DATE,
	used_date DATE
);


