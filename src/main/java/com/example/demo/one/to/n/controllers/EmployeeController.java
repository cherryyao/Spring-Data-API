package com.example.demo.one.to.n.controllers;

import com.example.demo.one.to.n.controllers.dto.EmployeeDTO;
import com.example.demo.one.to.n.entities.Company;
import com.example.demo.one.to.n.entities.Employee;
import com.example.demo.one.to.n.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee save(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @Transactional
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }

    @Transactional
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeDTO get(@PathVariable("id") Long id) {
        Employee employee = employeeRepository.findById(id).get();
        return new EmployeeDTO(employee);
    }

    @Transactional
    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee delete(@PathVariable("id")Long id) {
        Employee one = employeeRepository.findById(id).get();
        employeeRepository.delete(one);
        return one;
    }

    @Transactional
    @GetMapping(path = "/male",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> findByGender(){
       return  employeeRepository.findByGender("male");
    }








}
