package com.CertaTaskPro.CertaTask_TodoList.repository;
import com.CertaTaskPro.CertaTask_TodoList.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByNameIgnoreCase(String name);
}