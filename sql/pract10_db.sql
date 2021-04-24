
SET NAMES utf8;

DROP DATABASE IF EXISTS testDB;
CREATE DATABASE testDB CHARACTER SET utf8 COLLATE utf8_bin;

USE testDB;
-- --------------------------------------------------------------
-- ROLES
-- users roles
-- --------------------------------------------------------------
CREATE TABLE roles(
	id INTEGER NOT NULL PRIMARY KEY,
	name VARCHAR(10) NOT NULL UNIQUE
);

-- this two commands insert data into roles table
-- --------------------------------------------------------------
-- ATTENTION!!!
-- we use ENUM as the Role entity, so the numeration must started
-- from 0 with the step equaled to 1
-- --------------------------------------------------------------
INSERT INTO roles VALUES(0, 'admin');
INSERT INTO roles VALUES(1, 'client');

-- --------------------------------------------------------------
-- USERS
-- --------------------------------------------------------------
CREATE TABLE users(
	id INTEGER NOT NULL auto_increment PRIMARY KEY,
-- 'UNIQUE' means logins values should not be repeated in login column of table
	login VARCHAR(20) NOT NULL UNIQUE,
-- not null string columns
	password VARCHAR(20) NOT NULL,
-- this declaration contains the foreign key constraint
-- role_id in users table is associated with id in roles table
-- role_id of user = id of role
	role_id INTEGER NOT NULL REFERENCES roles(id)
-- removing a row with some ID from roles table implies removing
-- all rows from users table for which ROLES_ID=ID
-- default value is ON DELETE RESTRICT, it means you cannot remove
-- row with some ID from the roles table if there are rows in
-- users table with ROLES_ID=ID
		ON DELETE CASCADE
-- the same as previous but updating is used insted deleting
		ON UPDATE RESTRICT
);

-- id = 1
INSERT INTO users VALUES(DEFAULT, 'admin', 'admin', 0);
-- id = 2
INSERT INTO users VALUES(DEFAULT, 'client', 'client', 1);
-- id = 3
INSERT INTO users VALUES(DEFAULT, 'петров', 'петров', 1);

SELECT * FROM users;
SELECT * FROM roles;