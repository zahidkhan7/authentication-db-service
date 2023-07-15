create database vsaservice;

use vsaservice;

CREATE TABLE user_role (
 id INT NOT NULL AUTO_INCREMENT,
 code VARCHAR(10) NOT NULL,
 name VARCHAR(40) NOT NULL
PRIMARY KEY (id));

CREATE TABLE user_account (
  id int NOT NULL AUTO_INCREMENT,
  username varchar(100) NOT NULL,
  password varchar(100) NOT NULL,
  credentialsexpired bit(1) NOT NULL,
  enabled bit(1) NOT NULL,
  expired bit(1) NOT NULL,
  locked bit(1) NOT NULL,
  PRIMARY KEY (id)
  );


/*  
INSERTED Few Records for USER_ROLE.
However for USER_ACCOUNT we should add user Using API
*/ 
INSERT IGNORE INTO user_role VALUES (NULL, '101', 'ADMIN');
INSERT IGNORE INTO user_role VALUES (NULL, '102', 'ADMIN_TRAINEE');
INSERT IGNORE INTO user_role VALUES (NULL, '103', 'USER');
INSERT IGNORE INTO user_role VALUES (NULL, '104', 'GUEST');



