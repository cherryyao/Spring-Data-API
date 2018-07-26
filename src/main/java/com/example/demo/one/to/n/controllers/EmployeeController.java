package com.example.demo.one.to.n.controllers;

import com.example.demo.one.to.n.entities.Company;
import com.example.demo.one.to.n.entities.Employee;
import com.example.demo.one.to.n.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    @PostMapping(path = "",produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee save(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @Transactional
    @GetMapping(path = "",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }


}
