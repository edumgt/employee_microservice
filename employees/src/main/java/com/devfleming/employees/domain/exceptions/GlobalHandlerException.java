package com.devfleming.employees.domain.exceptions;

import com.devfleming.employees.domain.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

/**
 * Global handler, responsible to handle all exceptions, and return its information.
 * @author Rafael Fleming
 */
@ControllerAdvice
public class GlobalHandlerException {

    /**
     * Responsible to handle the creation employee failure.
     * @param exception Exception responsible to handle the creation employee failure.
     * @param webRequest Request of the user.
     * @return Error response containing the information of the failure.
     */
    @ExceptionHandler(CouldNotCreateEmployeeException.class)
    public ErrorResponseDto handleCouldNotCreateEmployeeException(CouldNotCreateEmployeeException exception,
                                                                  WebRequest webRequest){

        return ErrorResponseDto.builder()
                .apiPath(webRequest.getContextPath())
                .errorCode(HttpStatus.BAD_REQUEST)
                .errorMessage(exception.getMessage())
                .errorTime(LocalDateTime.now())
                .build();
    }

    /**
     * Responsible to handle the failure of updating the employee information.
     * @param exception Exception responsible to handle the failure of updating the employee information.
     * @param webRequest Request of the user.
     * @return Error response containing the information of the failure.
     */
    @ExceptionHandler(CouldNotUpdateEmployeeException.class)
    public ErrorResponseDto handleCouldNotUpdateEmployeeException(CouldNotUpdateEmployeeException exception,
                                                                  WebRequest webRequest){

        return ErrorResponseDto.builder()
                .apiPath(webRequest.getContextPath())
                .errorCode(HttpStatus.BAD_REQUEST)
                .errorMessage(exception.getMessage())
                .errorTime(LocalDateTime.now())
                .build();
    }

    /**
     * Responsible to handle the failure of searching the employee.
     * @param exception Exception responsible to handle the failure of searching the employee.
     * @param webRequest Request of the user.
     * @return Error response containing the information of the failure.
     */
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ErrorResponseDto handleEmployeeNotFoundException(EmployeeNotFoundException exception,
                                                                  WebRequest webRequest){

        return ErrorResponseDto.builder()
                .apiPath(webRequest.getContextPath())
                .errorCode(HttpStatus.NOT_FOUND)
                .errorMessage(exception.getMessage())
                .errorTime(LocalDateTime.now())
                .build();
    }

    /**
     * Responsible to handle the failure of creating an employee who already exists with that information (id, email, cellphone).
     * @param exception Exception responsible to handle the failure of creating an employee who already exists.
     * @param webRequest Request of the user.
     * @return Error response containing the information of the failure.
     */
    @ExceptionHandler(EmployeeAlreadyExistsException.class)
    public ErrorResponseDto handleEmployeeAlreadyExistsException(EmployeeAlreadyExistsException exception,
                                                            WebRequest webRequest){

        return ErrorResponseDto.builder()
                .apiPath(webRequest.getContextPath())
                .errorCode(HttpStatus.NOT_FOUND)
                .errorMessage(exception.getMessage())
                .errorTime(LocalDateTime.now())
                .build();
    }
}
