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
	id INT  NOT NULL AUTO_INCREMENT,
	company_id INT,
	campaing_id INT,
	campaing_name VARCHAR(25),
	barcode VARCHAR(50),
	create_date DATE,
	expire_date DATE,
	used_date DATE,
	PRIMARY KEY(id)
);


create table cpdb_campaigns (
	id INT NOT NULL AUTO_INCREMENT,
	owner_id INT,
	campaign_id VARCHAR(50),
	num_of_cards INT,
	campaign_name VARCHAR(50),
	campaign_detail VARCHAR(50),
	create_date DATE,
	expire_date DATE,
	PRIMARY KEY(id),
);

CREATE TABLE cpdb_categories(
	id INT NOT NULL AUTO_INCREMENT,
	category_name VARCHAR(150),
	PRIMARY KEY(id)
);
CREATE TABLE cpdb_campaign_categories(
	id INT NOT NULL AUTO_INCREMENT,
	campaign_id INT,
	category_id INT,
	FOREIGN KEY(campaign_id) REFERENCES cpdb_campaigns(id)
	FOREIGN KEY(category_id) REFERENCES cpdb_categories(id)
);