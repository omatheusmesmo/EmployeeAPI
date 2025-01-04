package com.omatheusmesmo.EmployeeAPI.service;

import com.omatheusmesmo.EmployeeAPI.model.Employee;
import com.omatheusmesmo.EmployeeAPI.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> findAll() {
        return repository.findAll();
    }

    public Optional<Employee> findById(Long id) {
        return repository.findById(id);
    }

    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    public Employee update(Long id, Employee employee) {
        return repository.findById(id).map(existingEmployee -> {
            existingEmployee.setName(employee.getName());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setPosition(employee.getPosition());
            existingEmployee.setSalary(employee.getSalary());
            return repository.save(existingEmployee);
        }).orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
