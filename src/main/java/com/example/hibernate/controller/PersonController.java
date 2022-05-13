package com.example.hibernate.controller;

import com.example.hibernate.model.Person;
import com.example.hibernate.repository.PersonJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class PersonController {

    @Autowired
    PersonJpaRepository personJpaRepository;

    @GetMapping("/persons/by-city")
    public String getPersonsByCity(String city) {
        return personJpaRepository.findAllByCity(city).toString();
    }

    @GetMapping("/persons/by-age")
    public String getPersonsByAge(int age) {
        return personJpaRepository.findAllByPersonKeyAgeLessThanOrderBy(age).toString();
    }

    @GetMapping("/persons/by-name-and-surname")
    public String getPersonsByNameAndSurname(String name, String surname) {
        List<Person> list = personJpaRepository.findAllByPersonKeyNameAndPersonKeySurname(name, surname).orElseThrow();
        return list.toString();
    }
}
