DROP TABLE IF EXISTS Employee;

CREATE TABLE Employee(
  id INT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(40) NOT NULL,
  last_name VARCHAR(40),
  email VARCHAR(40) NOT NULL,	
project VARCHAR(40),
  PRIMARY KEY (id));