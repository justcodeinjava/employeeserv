DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS address;
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
  country varchar(100),
  zipcode varchar(50),
  id INT,
  CONSTRAINT FK_ADDRESS_EMPLOYEE FOREIGN KEY (id) REFERENCES EMPLOYEES(id)
);

 
INSERT INTO employees (first_name, last_name,date_of_birth) VALUES
  ('Aliko', 'Dangote',{ts '2012-09-17 18:47:52.69'}),
  ('Bill', 'Gates',{ts '2012-09-17 18:47:52.69'}),
  ('Folrunsho', 'Alakija',{ts '2012-09-17 18:47:52.69'});
  
INSERT INTO address (line1,line2,city,state,country,zipcode,id) VALUES
  ('450 Main St', 'Unit # 556','Fremont','TX','USA','98907',1),
  ('550 Main St', 'Unit # 557','Fremont','TX','USA','98907',2),
   ('650 Main St', 'Unit # 558','Fremont','TX','USA','98907',3);
  
