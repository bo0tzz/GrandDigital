create database if not exists gd;
use gd;

create table if not exists products (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    title NVARCHAR(200) NOT NULL,
    available BOOLEAN NOT NULL,
    year INTEGER NOT NULL,
    type ENUM('STREAMING','BLU_RAY') NOT NULL,
    url NVARCHAR(100) NOT NULL,
    INDEX (title, year)
)