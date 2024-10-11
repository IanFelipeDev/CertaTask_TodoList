package com.CertaTaskPro.CertaTask_TodoList.service;

import com.CertaTaskPro.CertaTask_TodoList.entity.Employee;
import com.CertaTaskPro.CertaTask_TodoList.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeByName(String name) {
        return employeeRepository.findByNameIgnoreCase(name);
    }

    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
}