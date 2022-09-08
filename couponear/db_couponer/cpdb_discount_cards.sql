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
	PRIMARY KEY(id)
);
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (1, 1, 2, 'Discount For Friday', 'E1-27-3D-A6-8B-DE', '2021-11-10', '2022-12-08', '2022-10-05');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (2, 4, 1, 'Discount For Friday', '96-7B-B1-5C-26-21', '2022-04-22', '2023-02-03', '2022-10-16');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (3, 2, 3, 'Discount Sales Everything', '47-D7-65-E2-5F-49', '2022-05-16', '2023-03-13', '2022-04-03');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (4, 4, 1, 'Discount For Friday', '8A-31-43-0C-41-68', '2021-10-13', '2023-01-01', '2022-03-03');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (5, 1, 4, 'Discount Sales Everything', '61-BC-79-04-88-1F', '2022-07-29', '2022-12-05', '2022-08-27');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (6, 2, 4, 'Discount to Nothing', '68-0E-65-A4-DA-DC', '2022-06-27', '2023-03-12', '2022-09-22');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (7, 1, 5, 'Discount Sales Everything', 'E0-F0-1F-4C-F2-EC', '2021-09-08', '2023-01-29', '2022-04-15');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (8, 4, 4, 'Discount For Friday', '70-5F-D6-9C-B5-A1', '2021-12-01', '2022-12-16', '2022-06-26');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (9, 3, 1, 'Discount Sales Everything', 'D4-B1-AE-40-62-93', '2022-05-23', '2023-03-17', '2021-11-18');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (10, 4, 5, 'Discount Sales Everything', 'A2-03-FB-DB-99-6E', '2022-10-08', '2023-03-24', '2022-07-18');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (11, 4, 4, 'Discount to Nothing', '94-04-61-9F-D0-AE', '2022-11-03', '2022-12-15', '2021-12-30');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (12, 4, 2, 'Discount %25  up to', 'DA-CA-81-74-BC-8B', '2022-01-28', '2022-12-09', '2022-06-14');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (13, 5, 3, 'Discount Sales Everything', 'DA-CB-F1-D6-AF-8E', '2022-08-15', '2023-03-20', '2021-11-21');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (14, 5, 2, 'Discount to Nothing', '18-C5-04-0F-92-2E', '2022-01-20', '2023-01-26', '2023-02-21');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (15, 1, 1, 'Discount to Nothing', '01-33-5E-31-BA-31', '2022-09-10', '2023-03-12', '2022-01-18');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (16, 1, 2, 'Discount For Friday', '48-FB-61-BD-7B-59', '2022-07-16', '2023-03-01', '2022-09-22');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (17, 4, 4, 'Discount Sales Everything', '65-ED-9A-5D-A1-D9', '2022-11-27', '2023-03-01', '2022-11-22');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (18, 4, 5, 'Discount Sales Everything', '26-A0-ED-CE-95-3F', '2022-10-01', '2023-01-09', '2022-12-29');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (19, 3, 2, 'Discount %25  up to', '10-51-93-03-EF-3E', '2022-03-31', '2022-11-30', '2022-08-31');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (20, 4, 1, 'Discount For Friday', '78-B3-1A-D5-09-99', '2021-10-29', '2023-03-30', '2022-11-11');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (21, 3, 3, 'Discount %25  up to', '59-24-8A-5F-F1-74', '2021-11-20', '2022-12-11', '2022-07-22');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (22, 5, 5, 'Discount to Nothing', '6D-42-E4-93-28-6B', '2022-02-25', '2023-02-17', '2022-01-22');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (23, 5, 3, 'Discount For Friday', 'CD-EC-21-D9-F0-0B', '2021-10-04', '2023-02-04', '2021-11-06');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (24, 2, 5, 'Discount For Friday', 'A8-B9-D2-A8-20-18', '2022-11-08', '2022-12-16', '2022-06-06');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (25, 4, 4, 'Discount to Nothing', '26-32-1E-8C-7A-C1', '2022-02-01', '2023-03-16', '2022-10-04');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (26, 4, 2, 'Discount Sales Everything', 'DC-C9-C3-FB-07-9D', '2021-10-06', '2023-01-15', '2023-02-05');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (27, 5, 3, 'Discount to Nothing', '1C-41-B4-15-6A-EF', '2021-10-22', '2022-12-03', '2022-05-02');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (28, 4, 4, 'Discount For Friday', '19-A7-99-21-F8-5F', '2022-10-05', '2023-01-28', '2022-08-06');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (29, 3, 3, 'Discount Sales Everything', '0B-45-AA-82-21-E2', '2022-01-31', '2023-01-29', '2022-03-29');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (30, 1, 4, 'Discount %25  up to', '35-76-A5-49-E0-D0', '2022-01-05', '2023-03-01', '2022-03-04');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (31, 5, 2, 'Discount to Nothing', '34-02-69-F1-28-3D', '2022-10-19', '2022-12-23', '2022-10-15');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (32, 1, 2, 'Discount Sales Everything', 'D7-2B-25-84-CB-34', '2022-05-19', '2023-03-25', '2022-09-22');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (33, 2, 3, 'Discount Sales Everything', '95-EC-2C-B7-87-EA', '2022-03-09', '2023-01-14', '2022-11-04');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (34, 4, 1, 'Discount to Nothing', '4F-0D-6A-6F-C9-5A', '2022-04-26', '2022-12-25', '2021-11-13');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (35, 5, 3, 'Discount to Nothing', 'CC-1D-7A-8C-D3-87', '2022-06-05', '2023-03-08', '2022-03-24');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (36, 4, 4, 'Discount Sales Everything', '00-63-F9-DA-1B-DA', '2022-08-26', '2023-03-24', '2023-03-10');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (37, 4, 2, 'Discount %25  up to', 'BC-85-D1-4E-18-2B', '2021-12-24', '2023-02-02', '2022-10-28');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (38, 4, 4, 'Discount %25  up to', '60-DD-C6-0D-75-AF', '2022-02-01', '2023-03-11', '2021-12-03');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (39, 5, 4, 'Discount For Friday', '5A-D0-D1-6F-39-0A', '2021-09-09', '2023-01-18', '2022-05-31');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (40, 5, 2, 'Discount Sales Everything', '7B-FF-DC-A2-A1-4B', '2021-11-28', '2023-01-24', '2022-02-03');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (41, 5, 3, 'Discount %25  up to', 'E5-3A-7C-BC-A6-F0', '2022-10-23', '2023-03-05', '2022-09-09');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (42, 1, 2, 'Discount %25  up to', 'FC-3E-EC-12-FA-BF', '2021-10-24', '2023-01-07', '2022-10-13');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (43, 1, 3, 'Discount For Friday', '7C-CC-B1-06-ED-BE', '2022-10-08', '2023-03-08', '2022-03-07');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (44, 4, 1, 'Discount to Nothing', 'F1-E4-C3-54-D6-97', '2022-06-23', '2023-02-18', '2022-01-30');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (45, 4, 2, 'Discount %25  up to', '96-85-D0-33-93-A9', '2022-06-01', '2023-03-09', '2023-02-20');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (46, 5, 2, 'Discount For Friday', 'C0-80-48-6C-66-BC', '2022-01-05', '2022-12-26', '2022-11-09');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (47, 2, 2, 'Discount For Friday', '95-DE-12-37-36-39', '2022-08-24', '2023-01-06', '2022-08-03');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (48, 5, 3, 'Discount For Friday', '15-86-91-65-BC-F9', '2021-11-03', '2022-12-26', '2022-05-13');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (49, 4, 5, 'Discount For Friday', 'ED-90-17-9C-A2-22', '2021-11-19', '2023-03-26', '2023-02-02');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (50, 1, 5, 'Discount Sales Everything', '8E-A3-9E-90-95-BA', '2022-07-12', '2022-12-10', '2021-10-22');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (51, 3, 3, 'Discount %25  up to', '84-1B-51-76-39-31', '2022-09-10', '2023-03-07', '2021-12-02');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (52, 2, 1, 'Discount Sales Everything', 'FA-54-2A-0B-B0-51', '2022-01-11', '2023-01-21', '2022-07-13');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (53, 5, 3, 'Discount Sales Everything', '30-79-CA-A9-ED-E6', '2022-11-04', '2022-12-22', '2022-09-29');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (54, 2, 4, 'Discount %25  up to', '46-F2-A3-14-7D-99', '2021-11-26', '2023-01-02', '2022-03-20');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (55, 5, 2, 'Discount to Nothing', '37-F8-6E-77-FF-41', '2022-09-03', '2023-01-05', '2023-03-02');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (56, 3, 2, 'Discount Sales Everything', '3B-D3-5C-79-07-86', '2022-04-15', '2022-12-29', '2021-12-27');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (57, 4, 1, 'Discount to Nothing', 'B8-3C-24-DF-AC-EA', '2022-08-20', '2023-01-02', '2022-07-29');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (58, 1, 1, 'Discount For Friday', '54-14-B4-46-1C-3A', '2022-07-26', '2022-12-16', '2022-07-21');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (59, 4, 3, 'Discount to Nothing', 'DC-0E-FC-6B-A4-AC', '2022-05-14', '2023-03-29', '2022-05-18');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (60, 4, 3, 'Discount For Friday', '04-8B-21-AC-B7-07', '2021-12-11', '2023-01-24', '2022-01-11');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (61, 5, 4, 'Discount Sales Everything', '8B-E2-39-A8-80-03', '2022-10-05', '2023-01-08', '2022-08-09');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (62, 5, 2, 'Discount to Nothing', '9E-14-BB-BD-8A-80', '2021-12-04', '2022-12-09', '2022-08-02');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (63, 4, 4, 'Discount For Friday', '81-46-4F-DE-09-28', '2022-02-03', '2023-03-07', '2022-08-19');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (64, 5, 3, 'Discount to Nothing', '08-C3-33-90-F5-BA', '2021-12-06', '2023-02-25', '2022-10-21');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (65, 2, 1, 'Discount %25  up to', '26-A7-BA-23-D7-93', '2021-11-12', '2023-02-26', '2022-11-20');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (66, 5, 4, 'Discount For Friday', '6D-E3-DE-83-DC-CB', '2022-02-21', '2023-02-13', '2022-10-22');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (67, 5, 3, 'Discount to Nothing', '4F-2A-82-E5-5C-FA', '2022-05-23', '2023-03-05', '2023-03-12');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (68, 4, 4, 'Discount to Nothing', '78-D0-02-A7-49-38', '2022-08-07', '2022-12-15', '2022-11-01');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (69, 3, 4, 'Discount For Friday', '81-58-0D-CD-01-3C', '2021-12-08', '2023-02-09', '2022-02-13');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (70, 2, 5, 'Discount Sales Everything', 'E2-E1-17-EC-EE-F4', '2022-05-12', '2023-01-19', '2023-01-13');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (71, 3, 3, 'Discount %25  up to', 'BA-25-D8-46-EC-C4', '2022-07-27', '2022-12-27', '2022-02-27');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (72, 5, 5, 'Discount %25  up to', '3E-BE-F1-EF-60-EE', '2022-11-27', '2022-12-24', '2022-03-09');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (73, 2, 2, 'Discount For Friday', '3C-63-18-39-F6-A6', '2022-01-16', '2022-12-04', '2021-11-10');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (74, 2, 4, 'Discount Sales Everything', '08-F6-52-C6-DE-E2', '2022-05-02', '2022-12-29', '2022-05-31');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (75, 4, 4, 'Discount Sales Everything', '0A-58-73-29-64-97', '2022-05-05', '2023-01-27', '2023-03-28');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (76, 4, 3, 'Discount to Nothing', '45-9E-C7-9F-8C-8F', '2022-11-27', '2023-02-07', '2022-05-08');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (77, 4, 5, 'Discount Sales Everything', '17-8F-59-ED-1C-5C', '2021-09-09', '2023-03-16', '2021-11-27');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (78, 2, 4, 'Discount Sales Everything', '79-AD-23-33-5D-D0', '2021-12-29', '2023-02-25', '2022-04-10');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (79, 4, 4, 'Discount For Friday', '99-9C-AD-3F-7C-AD', '2022-09-24', '2023-03-25', '2022-03-13');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (80, 1, 2, 'Discount %25  up to', '1B-96-66-26-BD-E1', '2021-12-17', '2022-12-04', '2021-11-08');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (81, 5, 2, 'Discount For Friday', '1F-AD-E6-4D-9B-2D', '2022-05-08', '2022-12-16', '2022-01-01');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (82, 4, 4, 'Discount For Friday', '6C-DA-D5-9D-9C-D1', '2022-10-31', '2023-03-17', '2022-02-15');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (83, 3, 3, 'Discount to Nothing', '67-5E-47-C1-5A-A7', '2022-07-30', '2023-02-28', '2022-01-08');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (84, 4, 5, 'Discount For Friday', '11-DF-B4-25-DD-11', '2022-03-31', '2023-02-05', '2022-12-14');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (85, 1, 3, 'Discount to Nothing', '1C-B2-F8-96-77-2A', '2022-05-09', '2022-12-08', '2022-09-22');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (86, 3, 4, 'Discount Sales Everything', '0D-74-79-7A-63-0E', '2022-07-08', '2022-12-30', '2022-07-07');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (87, 3, 1, 'Discount %25  up to', 'A9-D0-AC-D1-20-A5', '2021-11-12', '2023-02-12', '2021-12-23');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (88, 3, 4, 'Discount to Nothing', '05-C2-8A-F6-F0-FE', '2022-09-12', '2023-02-25', '2021-12-24');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (89, 2, 4, 'Discount %25  up to', '71-C0-71-DE-CC-5F', '2022-11-19', '2023-03-19', '2023-03-28');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (90, 3, 4, 'Discount %25  up to', 'A4-4D-ED-40-DD-DB', '2022-09-08', '2023-02-03', '2022-08-16');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (91, 3, 2, 'Discount For Friday', '6B-E4-9B-D6-8C-4F', '2021-10-13', '2022-12-11', '2022-02-08');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (92, 3, 3, 'Discount to Nothing', '87-67-B9-23-DE-F0', '2022-11-15', '2023-03-10', '2023-01-30');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (93, 5, 1, 'Discount %25  up to', 'AA-21-17-F2-45-4F', '2022-10-22', '2023-01-28', '2022-01-06');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (94, 2, 1, 'Discount to Nothing', 'A1-FA-F5-1D-7D-33', '2022-11-17', '2023-01-04', '2022-11-16');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (95, 5, 4, 'Discount For Friday', '84-19-AE-DF-ED-C5', '2022-09-06', '2022-12-10', '2022-06-21');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (96, 3, 4, 'Discount Sales Everything', '8D-A4-84-AB-89-07', '2022-02-17', '2023-03-27', '2022-10-17');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (97, 1, 4, 'Discount to Nothing', '31-FD-62-11-0C-D5', '2022-07-20', '2022-12-18', '2022-02-22');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (98, 3, 5, 'Discount Sales Everything', '0D-1A-28-8E-BF-6A', '2022-04-21', '2022-12-11', '2022-01-14');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (99, 3, 1, 'Discount %25  up to', 'B7-E9-8A-77-F1-45', '2022-02-13', '2023-01-12', '2022-03-28');
insert into cpdb_discount_cards (id, company_id, campaing_id, campaing_name, barcode, create_date, expire_date, used_date) values (100, 1, 1, 'Discount %25  up to', '4C-E7-D0-E3-E9-41', '2021-12-28', '2023-02-18', '2021-10-19');
