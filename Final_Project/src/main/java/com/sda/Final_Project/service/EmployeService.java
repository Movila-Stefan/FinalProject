package com.sda.Final_Project.service;


import com.sda.Final_Project.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeService {
    Employee create(Employee employee);

    void createAll(List<Employee> employees);

    Optional<Employee> getEmployeById(Long id);

    Employee findByFirstName(String firstName);

    List<Employee>getAllEmployee();

    Employee updateEmployee(Employee  employee);

}
