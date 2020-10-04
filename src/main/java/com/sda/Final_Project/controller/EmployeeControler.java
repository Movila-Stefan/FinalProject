package com.sda.Final_Project.controller;

;
import com.sda.Final_Project.controler.repository.EmployeeRepository;
import com.sda.Final_Project.model.Employee;
import com.sda.Final_Project.service.EmployeService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/employees/")
public class EmployeeControler {

    @Autowired
    private EmployeeRepository employeeRepository;

    //get all Employee

    @GetMapping("ShowForm")
    public String showEmployeeFor() {
        return "add-employee";
    }

    @GetMapping("list")
    public String employees(Model model) {
        model.addAttribute("employees", this.employeeRepository.findAll());
        return "index";
    }

    @PostMapping("add")
    public String addEmployee(@Valid Employee employee, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "add-employee";
        }
        this.employeeRepository.save(employee);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Employee employee = this.employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid employee id : " + id));
        model.addAttribute("employee", employee);
        return "update-employee";
    }


    @PostMapping("update/{id}")
    public String updateEmployee(@PathVariable("id") long id, @Valid Employee employee, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            employee.setid(id);
            return "update-employee";
        }
        //update employee
        employeeRepository.save(employee);
        //getall employees (with update)
        model.addAttribute("employees", this.employeeRepository.findAll());
        return "index";
    }

    @DeleteMapping("delete/{id}")
    public String deleteEmployee(@PathVariable("id") long id, Model model) {
        Employee employee = this.employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid employee id : " + id));
        this.employeeRepository.delete(employee);
        model.addAttribute("employee", this.employeeRepository.findAll());
        return "index";
    }
}

