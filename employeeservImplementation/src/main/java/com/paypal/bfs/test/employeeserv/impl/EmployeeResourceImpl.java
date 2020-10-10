package com.paypal.bfs.test.employeeserv.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.dao.EmployeeEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementation class for employee resource.
 */
@RestController
public class EmployeeResourceImpl implements EmployeeResource {

	@Autowired
	private JdbcTemplate jtm;

	@Override
	public ResponseEntity<Employee> employeeGetById(String id) {

		try {
			String employeeGetQuery = "SELECT * FROM EMPLOYEES WHERE ID=?";
			EmployeeEntity employeeEntity = (EmployeeEntity) jtm.queryForObject(employeeGetQuery, new Object[] { id },
					new BeanPropertyRowMapper<EmployeeEntity>(EmployeeEntity.class));

			Employee employee = mapperToEmployee(employeeEntity);
			return new ResponseEntity<>(employee, HttpStatus.OK);
		} catch (EmptyResultDataAccessException e) {
			System.out.println("Employee not found. id = " + id);
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			System.out.println("Internal error. Exception = " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public ResponseEntity<String> employeeAdd(@RequestBody Employee newEmployee) {
		int employeeId =0;



		if(newEmployee != null) {

			//check for idempotency
			ResponseEntity<Employee>  alreadyExisitingEmployee = employeeGetById(String.valueOf(newEmployee.getId()));

			if(alreadyExisitingEmployee.getStatusCode().equals( HttpStatus.NOT_FOUND)) {
				try {
					//String employeeInsertSql = "INSERT INTO EMPLOYEES(id, first_name, last_name, date_of_birth,address_line_1,address_line_2,city,state,country,zipcode) VALUES(:id, :first_name, :last_name, :date_of_birth,address_line_1,address_line_2,city,state,country,zipcode)";
					String employeeInsertSql = "INSERT INTO EMPLOYEES(id, first_name, last_name, date_of_birth,address_line_1,address_line_2,city,state,country,zipcode) VALUES(?,?,?,?,?,?,?,?,?,?)";
					
					employeeId= jtm.update(employeeInsertSql, newEmployee.getId(), newEmployee.getFirstName(), newEmployee.getLastName(),
							newEmployee.getDateOfBirth(),newEmployee.getAddress().getLine1(),newEmployee.getAddress().getLine2(),
							newEmployee.getAddress().getCity(),newEmployee.getAddress().getState(),newEmployee.getAddress().getCountry(),newEmployee.getAddress().getZipcode());


				} catch (Exception e) {
					System.out.println("Internal error. Exception = " + e.getMessage());
					return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}else {
				return new ResponseEntity<>(String.valueOf(employeeId), HttpStatus.CONFLICT);
			}
		}

		return new ResponseEntity<>(String.valueOf(employeeId), HttpStatus.CREATED);
	}


	private Employee mapperToEmployee(EmployeeEntity employeeEntity) {
		Employee employee= new Employee();
		Address address = new Address();

		address.setLine1(employeeEntity.getAddress_line_1());
		address.setLine2(employeeEntity.getAddress_line_2());
		address.setCity(employeeEntity.getCity());
		address.setState(employeeEntity.getState());
		address.setCountry(employeeEntity.getCountry());
		address.setZipcode(employeeEntity.getZipcode());

		employee.setAddress(address);
		employee.setId(employeeEntity.getId());
		employee.setFirstName(employeeEntity.getFirstName());
		employee.setFirstName(employeeEntity.getLastName());
		employee.setDateOfBirth(employeeEntity.getDateOfBirth());		

		return employee;

	}



}
