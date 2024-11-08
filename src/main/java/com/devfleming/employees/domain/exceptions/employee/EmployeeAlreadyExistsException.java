package com.devfleming.employees.domain.exceptions.employee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception class responsible to prevent duplicated unique information like e-mail and cellphone.
 * @author Rafael Fleming
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeAlreadyExistsException extends RuntimeException {
    public EmployeeAlreadyExistsException(String message) {
        super(message);
    }
}
