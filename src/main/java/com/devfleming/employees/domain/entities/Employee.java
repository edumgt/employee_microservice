package com.devfleming.employees.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * Defines the employee entity.
 * @author Rafael Fleming
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EntityListeners(value = AuditingEntityListener.class)
@Table(name = "employee")
public class Employee extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", unique = true, nullable = false, updatable = false)
    private Long employeeId;

    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 60)
    private String lastName;

    @Column(name = "cpf", unique = true, nullable = false, length = 11)
    private String cpf;

    @Column(name = "rg", unique = true, nullable = false, length = 9)
    private String rg;

    @Column(name = "employee_email", unique = true, nullable = false, length = 60)
    private String employeeEmail;

    @Column(name = "area_code", nullable = false, length = 3)
    private String areaCode;

    @Column(name = "cellphone_number", unique = true, nullable = false, length = 9)
    private String employeeCellphone;

    @Column(name = "active", nullable = false, length = 1)
    private Character active;
}
