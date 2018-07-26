package com.example.demo.one.to.one.controllers;

import com.example.demo.one.to.one.repositories.KlassRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
public class KlassController {
    @Autowired
    private KlassRepositories klassRepositories;

}
