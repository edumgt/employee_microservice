package com.devfleming.employees;

import com.devfleming.employees.domain.usecases.EmployeeService;
import com.devfleming.employees.repositories.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeesApplicationTests {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeService employeeService;

	@Test
	void contextLoads() {
		assertNotNull(employeeRepository);
		assertNotNull(employeeService);
	}

}
