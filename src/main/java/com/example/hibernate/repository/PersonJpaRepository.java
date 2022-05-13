package com.example.hibernate.repository;

import com.example.hibernate.model.Person;
import com.example.hibernate.model.PersonKey;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonJpaRepository extends JpaRepository<Person, PersonKey> {

    List<Person> findAllByCity(String city);

    List<Person> findAllByPersonKeyAgeLessThan(int ageLessThan, Sort sort);

    Optional<List<Person>> findAllByPersonKeyNameAndPersonKeySurname(String name, String surname);
}
