package com.devfleming.employees.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Set;

/**
 * Employee Data Transfer Object for creation, updating and other process related to the employee entity.
 * @author Rafael Fleming
 */
@Getter @Setter @ToString
@Builder
@AllArgsConstructor
@Schema(
        name = "Employee Data Transfer Object",
        description = "DTO responsible to carry the employee information for CRUD operations."
)
public class EmployeeDto {

    @NotNull(message = "First name cannot be null.")
    @Length(min = 1, max = 30, message = "This field should have between 1 and 30 characters.")
    @Schema(description = "Employee first name", example = "John")
    private String firstName;

    @NotNull(message = "Last name cannot be null.")
    @Length(min = 1, max = 60, message = "This field should have between 1 and 60 characters.")
    @Schema(description = "Employee last name", example = "Durandal Spark")
    private String lastName;

    @NotNull(message = "CPF cannot be null.")
    @CPF(message = "This field should have 14 characters. Example: 000.000.000-00")
    @Schema(description = "Employee CPF number", example = "000.000.000-00")
    private String cpf;

    @NotNull(message = "RG cannot be null.")
    @Length(min = 12, max = 12, message = "This field should have 12 characters. Example: 00.000.000-0")
    @Schema(description = "Employee rg number", example = "00.000.000-0")
    private String rg;

    @NotNull(message = "E-mail cannot be null.")
    @Email(message = "Invalid e-mail format. Example: employee@company.com")
    @Schema(description = "Employee e-mail", example = "employee@company.com")
    private String email;

    @NotNull(message = "Area code cannot be null.")
    @Length(min = 2, max = 3, message = "Invalid area code. Example: 12, 534")
    @Schema(description = "Employee area code of the cellphone number", example = "12")
    private String areaCode;

    @NotNull(message = "Cellphone number cannot be null.")
    @Length(min = 8, max = 9, message = "Invalid cellphone number. Example 912345678")
    @Schema(description = "Employee cellphone number", example = "912345678")
    private String cellphoneNumber;
}
