package com.paypal.bfs.test.employeeserv;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import java.lang.reflect.*;

@SpringBootApplication
@ComponentScan({"com.paypal*"})
@EntityScan("com.paypal*")
@EnableJpaRepositories("com.paypal*")
public class EmployeeservApplication {
	
    @Autowired
    private JdbcTemplate jtm;
    
    public static void main(String[] args) {
        SpringApplication.run(EmployeeservApplication.class, args);
    }
    
    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        System.out.println("hello world, I have just started up");
        
        String sql = "SELECT * FROM employees";

        System.out.println(jtm.query(sql, new BeanPropertyRowMapper<>(Employee.class)));
        
        Employee employee = new Employee();

        employee.setFirstName("BFS");
        employee.setLastName("Developer");
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date birthDate = null;
		try {
			birthDate = sdf.parse("11/24/1981");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
       employee.setDateOfBirth(birthDate);
       Address address = new Address();
       address.setLine1("450 Main St,");
       address.setLine2("Unit 555");
        address.setCity("Fremont");
        address.setState("Texas");
        address.setCountry("USA");
        address.setZipcode("94066");
        employee.setAddress(address);
        System.out.println(employee.getAdditionalProperties());
        Field[] fields = Employee.class.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonProperty.class)) {
                String annotationValue = field.getAnnotation(JsonProperty.class).value();
                System.out.println(field.getName() + " " +field.getType());
            }
        }
        
        
    }
}