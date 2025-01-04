package com.omatheusmesmo.EmployeeAPI.controller;

import com.omatheusmesmo.EmployeeAPI.model.Employee;
import com.omatheusmesmo.EmployeeAPI.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * API endpoint for managing employee data.
 */
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    /**
     * Autowired instance of the EmployeeService, providing access to employee data operations.
     */
    @Autowired
    private EmployeeService service;

    /**
     * Returns a list of all employees in the system.
     *
     * @return List of Employee objects
     */
    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.findAll();
    }

    /**
     * Retrieves an employee by its ID.
     *
     * @param id Unique identifier of the employee to retrieve
     * @return ResponseEntity containing the employee data or a not found response
     */
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(GettingEmployeeNotFound().build());
    }

    /**
     * Creates a new employee in the system.
     *
     * @param employee Details of the employee to create
     * @return ResponseEntity containing the newly created employee data
     */
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(service.save(employee));
    }

    /**
     * Updates an existing employee in the system.
     *
     * @param id      Unique identifier of the employee to update
     * @param employee Updated employee details
     * @return ResponseEntity containing the updated employee data
     */
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return ResponseEntity.ok(service.update(id, employee));
    }

    /**
     * Deletes an existing employee from the system.
     *
     * @param id Unique identifier of the employee to delete
     * @return ResponseEntity containing a no-content response
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}