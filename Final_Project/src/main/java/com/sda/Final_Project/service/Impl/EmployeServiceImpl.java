package com.sda.Final_Project.service.Impl;


import com.sda.Final_Project.controler.repository.EmployeeRepository;
import com.sda.Final_Project.model.Employee;
import com.sda.Final_Project.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeServiceImpl implements EmployeService {

private EmployeeRepository employeeRepository;
@Autowired
    public EmployeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee create(Employee employee) {
        return employeeRepository.saveAndFlush(employee);
    }

    @Override
    public void createAll(List<Employee> employees) {

    }

    @Override
    public Optional<Employee> getEmployeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee findByFirstName(String firstName) {
        return null;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();

    }

    @Override
    public Employee updateEmployee(Employee employee) {
return employeeRepository.saveAndFlush(employee);
    }
}
