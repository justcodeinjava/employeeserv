package com.paypal.bfs.test.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paypal.bfs.test.employeeserv.api.model.Employee;







@Repository
@Qualifier("employeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	Employee findById(String id);


}