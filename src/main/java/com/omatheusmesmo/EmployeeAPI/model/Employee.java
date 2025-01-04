package com.omatheusmesmo.EmployeeAPI.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * Represents an Employee entity in the database.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "employees")
public class Employee {

    /**
     * Unique identifier for the employee, auto-incrementing upon insertion.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of the employee.
     */
    @Column(nullable = false)
    private String name;

    /**
     * Unique email address for the employee.
     */
    @Column(nullable = false, unique = true)
    private String email;

    /**
     * Department or role that the employee occupies.
     */
    @Column(nullable = false)
    private String position;

    /**
     * Salary of the employee.
     */
    @Column(nullable = false)
    private Double salary;
}