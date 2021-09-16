package com.aws.a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.aws.a.entity.Person;
import com.aws.a.repository.Personrepo;

@RestController
public class PersonController {

    @Autowired
    private Personrepo personrepo;

    @PostMapping("/persons")
    public Person saveperson(@RequestBody Person person) {
        return personrepo.save(person);
    }

    @GetMapping("/persons/{id}")
    public Person getPerson(@PathVariable("id") String aadharid) {
        return personrepo.getPersonById(aadharid);
    }

    @DeleteMapping("/persons/{id}")
    public String deleteperson(@PathVariable("id") String aadharid) {
        return  personrepo.delete(aadharid);
    }

    @PutMapping("/persons/{id}")
    public String updateperson(@PathVariable("id") String aadharid, @RequestBody Person person) {
        return personrepo.update(aadharid,person);
    }
}