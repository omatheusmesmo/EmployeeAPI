package com.omatheusmesmo.EmployeeAPI.service;

import com.omitheusmesmo.EmployeeAPI.model.Employee;
import com.omatheusmesmo.EmployeeAPI.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Provides basic CRUD operations for Employee entities.
 *
 * @author [Your Name]
 */
@Service
public class EmployeeService {

    /**
     * The employee repository, used to interact with the database.
     */
    @Autowired
    private EmployeeRepository repository;

    /**
     * Retrieves all employees from the database.
     *
     * @return A list of all employees.
     */
    public List<Employee> findAll() {
        return repository.findAll();
    }

    /**
     * Finds an employee by its ID in the database.
     *
     * @param id The ID of the employee to find.
     * @return An optional containing the employee, or empty if not found.
     */
    public Optional<Employee> findById(Long id) {
        return repository.findById(id);
    }

    /**
     * Saves a new employee to the database.
     *
     * @param employee The employee to save.
     * @return The saved employee.
     */
    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    /**
     * Updates an existing employee in the database.
     *
     * @param id    The ID of the employee to update.
     * @param employee The updated employee details.
     * @return The updated employee.
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
     * Deletes an employee from the database by its ID.
     *
     * @param id The ID of the employee to delete.
     */
    public void delete(Long id) {
        repository.deleteById(id);
    }
}