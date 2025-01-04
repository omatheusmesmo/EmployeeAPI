package com.omatheusmesmo.EmployeeAPI.repository;

import com.omatheusmesmo.EmployeeAPI.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
