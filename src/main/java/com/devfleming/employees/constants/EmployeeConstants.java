package com.devfleming.employees.constants;

import lombok.NoArgsConstructor;

/**
 * Employee constants, responsible for declare Http Status Code and Message variables that are not going to change.
 * @author Rafael Fleming
 */
@NoArgsConstructor
public class EmployeeConstants {

    public final static String STATUS_200 = "200";

    public final static String MESSAGE_200 = "Request processed successfully";

    public final static String STATUS_201 = "201";

    public final static String MESSAGE_201 = "Employee created successfully";
}
