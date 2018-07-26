package com.example.demo.one.to.n.controllers;

import com.example.demo.one.to.n.entities.Company;
import com.example.demo.one.to.n.repositories.CompanyRepository;
import com.example.demo.one.to.n.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;


@RestController
@RequestMapping("/api/v1/companies")
public class CompanyController {

    @Autowired
    private CompanyRepository repository;

    //@Autowired
    //public CompanyController(CompanyRepository repository) {
//        this.repository = repository;
//    }

    @Transactional
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Company save(@RequestBody Company company){
        company.getEmployeesList().stream().forEach(employee -> employee.setCompany(company));
        return repository.save(company);
    }

//    @Transactional
//    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<Company> findAll(){
//        return repository.findAll();
//    }



}

