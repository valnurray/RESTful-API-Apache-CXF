CREATE DATABASE IF NOT EXISTS lankin;
USE lankin;

CREATE TABLE article
(id INT PRIMARY KEY AUTO_INCREMENT,
 author VARCHAR(75) NOT NULL,
 title VARCHAR(120) NOT NULL,
 body VARCHAR(255)
);