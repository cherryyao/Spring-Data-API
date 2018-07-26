package com.example.demo.one.to.one.controllers;

import com.example.demo.one.to.one.entities.Klass;
import com.example.demo.one.to.one.repositories.KlassRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/klasses")
public class KlassController {
    @Autowired
    private KlassRepositories klassRepositories;

    @Transactional
    @PostMapping(path = "",produces = MediaType.APPLICATION_JSON_VALUE)
    public Klass add(@RequestBody Klass klass){
       return klassRepositories.save(klass);
    }




}
