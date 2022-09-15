-- Active: 1651576140687@@127.0.0.1@3306
CREATE DATABASE couponeardb
    DEFAULT CHARACTER SET = 'utf8mb4';

CREATE TABLE cpdb_users(
    id  INT NOT NULL AUTO_INCREMENT,
    user_uid VARCHAR(65),
    first_name VARCHAR(65),
    surname VARCHAR(65),
    mail VARCHAR(65),
	available_system_cards INT,
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
	user_id INT,
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

CREATE TABLE cpdb_rules(
	id INT NOT NULL AUTO_INCREMENT,
	rule_name VARCHAR(500),
	create_date DATE,
	rule_type ENUM("R_CAMPAIGN","R_DEFAULT"),
	PRIMARY KEY(id)
);

CREATE TABLE cpdb_campaign_rules(
	id INT NOT NULL AUTO_INCREMENT,
	rule_id INT,
	campaign_id INT,
	FOREIGN KEY(rule_id) REFERENCES cpdb_rules(id),
	Foreign Key (campaign_id) REFERENCES  cpdb_campaigns(id)
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
	PRIMARY KEY(id),
	FOREIGN KEY(campaign_id) REFERENCES cpdb_campaigns(id),
	FOREIGN KEY(category_id) REFERENCES cpdb_categories(id)
);


CREATE TABLE cpdb_user_references(
	id INT NOT NULL AUTO_INCREMENT,
	user_id INT,
	reference_id INT,
	PRIMARY KEY(id),
	FOREIGN KEY(user_id) REFERENCES cpdb_users(id),
	FOREIGN KEY(reference_id) REFERENCES cpdb_users(id)
);