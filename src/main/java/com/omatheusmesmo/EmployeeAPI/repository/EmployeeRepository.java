/**
 * The base Spring Data JPA repository for Employee entities.
 *
 * Provides basic CRUD operation methods for Employee resources.
 */
package com.omatheusmesmo.EmployeeAPI.repository;

import com.omatheusmesmo.EmployeeAPI.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Extends JpaRepository to automatically provide basic operations (CRUD) for the Employee entity.
 * Inherits from the JpaRepository's generic type parameters to specify the Employee entity and its ID type as Long.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}