package com.devfleming.employees.domain.exceptions.employee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception class responsible to handle the update failure of the employee entity.
 * @author Rafael Fleming
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CouldNotUpdateEmployeeException extends RuntimeException {
    public CouldNotUpdateEmployeeException(String message) {
        super(message);
    }
}
