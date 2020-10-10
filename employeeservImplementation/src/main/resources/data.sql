DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS address;
CREATE TABLE employees (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  date_of_birth DATE, 
  address_line_1 VARCHAR(255) NOT NULL,
  address_line_2 VARCHAR(255),
  city varchar(100),
  state varchar(100),
  country varchar(100),
  zipcode varchar(50)
);

 
INSERT INTO employees (first_name, last_name,date_of_birth,address_line_1,address_line_2,city,state,country,zipcode) VALUES
  ('Aliko', 'Dangote',{ts '2012-09-17 18:47:52.69'},'450 Main St', 'Unit # 556','Fremont','TX','USA','98907'),
  ('Bill', 'Gates',{ts '2012-09-17 18:47:52.69'},'550 Main St', 'Unit # 557','Fremont','TX','USA','98907'),
  ('Folrunsho', 'Alakija',{ts '2012-09-17 18:47:52.69'},'650 Main St', 'Unit # 558','Fremont','TX','USA','98907');

  
