package com.omatheusmesmo.EmployeeAPI.controller;

import com.omatheusmesmo.EmployeeAPI.model.Employee;
import com.omatheusmesmo.EmployeeAPI.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing employee data.
 */
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    /**
     * Service layer instance to interact with the employee data source.
     */
    @Autowired
    private EmployeeService service;

    /**
     * Retrieves a list of all employees.
     *
     * @return a list of all employees
     */
    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.findAll();
    }

    /**
     * Retrieves an employee by its ID.
     *
     * @param id the ID of the employee to retrieve
     * @return the retrieved employee, with 200 OK if found, or 404 Not Found otherwise
     */
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Creates a new employee.
     *
     * @param employee the employee data to create
     * @return the created employee, with 201 Created if successful
     */
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(service.save(employee));
    }

    /**
     * Updates an existing employee.
     *
     * @param id     the ID of the employee to update
     * @param employee the updated employee data
     * @return the updated employee, with 200 OK if successful
     */
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return ResponseEntity.ok(service.update(id, employee));
    }

    /**
     * Deletes an existing employee.
     *
     * @param id the ID of the employee to delete
     * @return a 204 No Content response if successful
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}