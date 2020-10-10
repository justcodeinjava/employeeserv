DROP TABLE IF EXISTS employees;
 
CREATE TABLE employees (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  date_of_birth DATE
);

CREATE TABLE address (
  address_id INT AUTO_INCREMENT  PRIMARY KEY,
  line1 VARCHAR(255) NOT NULL,
  line2 VARCHAR(255),
  city varchar(100),
  state varchar(100),
  country(100),
  zipcode(50),
  id INT,
  foreign key (id) references employees(id)
);

 
INSERT INTO employees (first_name, last_name,date_of_birth) VALUES
  ('Aliko', 'Dangote','10/12/1909'),
  ('Bill', 'Gates','11/12/1909'),
  ('Folrunsho', 'Alakija','11/01/1890');
