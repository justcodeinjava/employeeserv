package com.paypal.bfs.test.employeeserv.impl;

import com.paypal.bfs.test.employeeentity.Address;
import com.paypal.bfs.test.employeeentity.Employee;
import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.repository.AddressRepository;
import com.paypal.bfs.test.repository.EmployeeRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


/**
 * Implementation class for employee resource.
 */
@RestController
public class EmployeeResourceImpl implements EmployeeResource {


	@Override
	public ResponseEntity<Employee> employeeGetById(String id) {
		HttpStatus status= null;
		
		    	String employeeSql = "SELECT * FROM EMPLOYEES WHERE ID=?";
		    	Employee employee = (Employee) jtm.queryForObject(employeeSql, new Object[]{id},
		                new BeanPropertyRowMapper<Employee>(Employee.class));
		    	String addressSql= "SELECT * FROM ADDRESS WHERE ID=?";
		    	Address address = (Address) jtm.queryForObject(addressSql, new Object[]{id},
		                new BeanPropertyRowMapper<Address>(Address.class));
		    	employee.setAddress(address);
		        return new ResponseEntity<>(employee, HttpStatus.OK);

//		Employee employee= employeeRepository.findById(id);
//		Address address = addressRepository.findById(id);
//		employee.setAddress(address);
//		if(employee != null) {
//			status =HttpStatus.OK;
//		}else {
//			status =HttpStatus.NOT_FOUND;
//		}
//		return new ResponseEntity<Employee>(employee, status);

	}
//
//	@Override
//	public ResponseEntity<Employee> createEmployee(Employee newEmployee) {
//		// TODO Auto-generated method stub
//
//		
//		employeeRepository.save(newEmployee);
//		return null;
//	}

	@Override
	public ResponseEntity<com.paypal.bfs.test.employeeserv.api.Employee> createEmployee(
			com.paypal.bfs.test.employeeserv.api.Employee newEmployee) {
		// TODO Auto-generated method stub
		employeeRepository.save(newEmployee);
		return null;
	}
@Override
public ResponseEntity<com.paypal.bfs.test.employeeserv.api.Employee> createEmployee(
		com.paypal.bfs.test.employeeserv.api.Employee newEmployee) {
	// TODO Auto-generated method stub
	return null;
}

}





//package com.paypal.bfs.test.employeeserv.impl;
//
//import com.paypal.bfs.test.employeeentity.Address;
//import com.paypal.bfs.test.employeeentity.Employee;
//import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
//import com.paypal.bfs.test.repository.AddressRepository;
//import com.paypal.bfs.test.repository.EmployeeRepository;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RestController;
//
//
///**
// * Implementation class for employee resource.
// */
//@RestController
//public class EmployeeResourceImpl implements EmployeeResource {
//
//
//	@Autowired(required=true)
//	private EmployeeRepository employeeRepository;
//
//	@Autowired(required=true)
//	private AddressRepository addressRepository;
//	@Override
//	public ResponseEntity<Employee> employeeGetById(String id) {
//		HttpStatus status= null;
//		
//		    	String employeeSql = "SELECT * FROM EMPLOYEES WHERE ID=?";
//		    	Employee employee = (Employee) jtm.queryForObject(employeeSql, new Object[]{id},
//		                new BeanPropertyRowMapper<Employee>(Employee.class));
//		    	String addressSql= "SELECT * FROM ADDRESS WHERE ID=?";
//		    	Address address = (Address) jtm.queryForObject(addressSql, new Object[]{id},
//		                new BeanPropertyRowMapper<Address>(Address.class));
//		    	employee.setAddress(address);
//		        return new ResponseEntity<>(employee, HttpStatus.OK);
//
////		Employee employee= employeeRepository.findById(id);
////		Address address = addressRepository.findById(id);
////		employee.setAddress(address);
////		if(employee != null) {
////			status =HttpStatus.OK;
////		}else {
////			status =HttpStatus.NOT_FOUND;
////		}
////		return new ResponseEntity<Employee>(employee, status);
//
//	}
////
////	@Override
////	public ResponseEntity<Employee> createEmployee(Employee newEmployee) {
////		// TODO Auto-generated method stub
////
////		
////		employeeRepository.save(newEmployee);
////		return null;
////	}
//
//	@Override
//	public ResponseEntity<com.paypal.bfs.test.employeeserv.api.Employee> createEmployee(
//			com.paypal.bfs.test.employeeserv.api.Employee newEmployee) {
//		// TODO Auto-generated method stub
//		employeeRepository.save(newEmployee);
//		return null;
//	}
//
//}
