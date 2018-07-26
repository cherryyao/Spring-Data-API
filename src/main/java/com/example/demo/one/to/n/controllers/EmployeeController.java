package com.example.demo.one.to.n.controllers;

import com.example.demo.one.to.n.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
}
