package com.example.demo.one.to.n.controllers;

import com.example.demo.one.to.n.entities.Company;
import com.example.demo.one.to.n.entities.Employee;
import com.example.demo.one.to.n.repositories.CompanyRepository;
import com.example.demo.one.to.n.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    //@Autowired
    //public CompanyController(CompanyRepository repository) {
//        this.repository = repository;
//    }

    @Transactional
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Company save(@RequestBody Company company){
        company.getEmployeesList().stream().forEach(employee -> employee.setCompany(company));
        return companyRepository.save(company);
    }

    @Transactional
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Company> findAll(){
        return companyRepository.findAll();
    }

    @Transactional
    @PutMapping(path = "/{company_id}/employees",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addEmployeeToCompany(@PathVariable Long company_id,@RequestBody Employee employee){
        Company company = companyRepository.findById(company_id).get();
        employee.setCompany(company);
        employeeRepository.save(employee);
        companyRepository.save(company);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }



}

