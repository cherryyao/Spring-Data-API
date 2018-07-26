package com.example.demo.one.to.n.controllers;

import com.example.demo.one.to.n.entities.Company;
import com.example.demo.one.to.n.entities.Employee;
import com.example.demo.one.to.n.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

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

//    @Transactional
//    @PutMapping(path = "/{employee_id}/{company_id}",produces = MediaType.APPLICATION_JSON_VALUE)
//    public Company setCompanyToEmployee(@PathVariable long employee_id,@PathVariable long company_id,@RequestBody Company company,@RequestBody Employee employee){
//        if (company.getId().equals(company_id))
//        {
//            if (employee.getEmployee_id()==employee_id){
//            employee.setCompany(company);
//            return company;
//        }
//        }
//        return null;
//    }
}
