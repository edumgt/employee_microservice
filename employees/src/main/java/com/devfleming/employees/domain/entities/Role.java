package com.devfleming.employees.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Role class of the employees.
 * Contains the role id, role name and if the role is active or not.
 * @author Rafael Fleming
 */

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EntityListeners(value = AuditingEntityListener.class)
@Table(name = "EMPLOYEE_ROLE")
public class Role extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID", unique = true, nullable = false)
    private Long roleId;

    @Column(name = "ROLE_NAME", unique = true, nullable = false, length = 50)
    private String roleName;

    @Column(name = "ACTIVE", nullable = false)
    private boolean active;
}
