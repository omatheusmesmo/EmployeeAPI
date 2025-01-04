package com.omatheusmesmo.EmployeeAPI.service;

import com.omatheusmesmo.EmployeeAPI.model.Employee;
import com.omatheusmesmo.EmployeeAPI.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing employee data.
 */
@Service
public class EmployeeService {

    /**
     * Autonomous repository instance for performing CRUD operations on employees.
     */
    @Autowired
    private EmployeeRepository repository;

    /**
     * Retrieve all employees from the database.
     *
     * @return A list of all employees in the system.
     */
    public List<Employee> findAll() {
        return repository.findAll();
    }

    /**
     * Retrieve an employee by their unique identifier.
     *
     * @param id The identifier of the employee to find.
     * @return An Optional containing the employee data, or an empty Optional if not found.
     */
    public Optional<Employee> findById(Long id) {
        return repository.findById(id);
    }

    /**
     * Save a new employee to the database and update any existing one with the same ID.
     *
     * @param employee The employee to save.
     * @return The saved employee data.
     */
    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    /**
     * Update an existing employee in the database with the specified ID.
     *
     * @param id       The identifier of the employee to update.
     * @param employee The updated employee data.
     * @return The updated employee data.
     * @throws RuntimeException If the employee is not found with the given ID.
     */
    public Employee update(Long id, Employee employee) {
        return repository.findById(id).map(existingEmployee -> {
            existingEmployee.setName(employee.getName());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setPosition(employee.getPosition());
            existingEmployee.setSalary(employee.getSalary());
            return repository.save(existingEmployee);
        }).orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
    }

    /**
     * Delete an employee by their unique identifier from the database.
     *
     * @param id The identifier of the employee to delete.
     */
    public void delete(Long id) {
        repository.deleteById(id);
    }
}