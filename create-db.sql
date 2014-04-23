DROP DATABASE IF EXISTS BOOKSHELF;
CREATE DATABASE BOOKSHELF;
USE BOOKSHELF;

CREATE TABLE BOOK(
ISBN INT UNSIGNED NOT NULL,
NAME VARCHAR (100) NOT NULL,
PRICE DOUBLE NOT NULL,
AUTHOR CHAR (32) NOT NULL,
PRIMARY KEY(ISBN)
);
