create database if not exists gd;
use gd;

create table if not exists products (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name NVARCHAR(200) NOT NULL,
    available BOOLEAN NOT NULL,
    year INTEGER NOT NULL,
    type ENUM('Streaming','Blu Ray') NOT NULL,
    image NVARCHAR(100) NOT NULL,
    INDEX (name, year)
)