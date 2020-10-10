package com.paypal.bfs.test.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paypal.bfs.test.employeeentity.Address;

@Repository
@Qualifier("addressRepository")
public interface AddressRepository extends JpaRepository<Address, Long>{
	Address findById(String id);


}