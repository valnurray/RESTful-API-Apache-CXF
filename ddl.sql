CREATE DATABASE IF NOT EXISTS lankin;
USE lankin;

CREATE TABLE author
(author_id INT PRIMARY KEY AUTO_INCREMENT,
 `description` VARCHAR(255),
 first_name VARCHAR(120) NOT NULL,
 last_name VARCHAR(120) NOT NULL
);

CREATE TABLE article
(id INT PRIMARY KEY AUTO_INCREMENT,
 body VARCHAR(255),
 title VARCHAR(120) NOT NULL,
 FOREIGN KEY (id) REFERENCES author(author_id)
);

-- CREATE TABLE article
-- (id INT PRIMARY KEY AUTO_INCREMENT,
--  author VARCHAR(75) NOT NULL,
--  title VARCHAR(120) NOT NULL,
--  body VARCHAR(255)
-- );

-- CREATE TABLE author
-- (author_id INT PRIMARY KEY AUTO_INCREMENT,
--  firstName VARCHAR(120) NOT NULL,
--  lastName VARCHAR(120) NOT NULL,
--  `description` VARCHAR(255)
-- );
--
-- CREATE TABLE article
-- (id INT PRIMARY KEY AUTO_INCREMENT,
--  title VARCHAR(120) NOT NULL,
--  body VARCHAR(255),
--  FOREIGN KEY (id) REFERENCES author(author_id)
-- );