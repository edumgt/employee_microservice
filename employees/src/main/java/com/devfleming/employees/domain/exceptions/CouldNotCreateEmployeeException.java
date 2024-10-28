package com.devfleming.employees.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception class responsible to handle the creation failure of the employee information.
 * @author Rafael Fleming
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CouldNotCreateEmployeeException extends RuntimeException {
    public CouldNotCreateEmployeeException(String message) {
        super(message);
    }
}
