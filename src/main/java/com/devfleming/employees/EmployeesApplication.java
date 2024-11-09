package com.devfleming.employees;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@OpenAPIDefinition(
		info = @Info(
				title = "Employee microservice REST API Documentation",
				description = "This section is about the REST API Documentation of employee microservice",
				version = "1.0.0",
				contact = @Contact(
						name = "Rafael Fleming",
						email = "rfleming1235@gmail.com"),
				license = @License(
						name = "Apache 2.0")
		)
)
public class EmployeesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeesApplication.class, args);
	}

}
