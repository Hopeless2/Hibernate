package com.example.hibernate.repository;

import com.example.hibernate.model.Person;
import com.example.hibernate.model.PersonKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonJpaRepository extends JpaRepository<Person, PersonKey> {

    @Query("select p from Person p where p.city = :city")
    List<Person> findAllByCity(String city);

    @Query("select p from Person p where p.personKey.age < :ageLessThan order by(p.personKey.age)")
    List<Person> findAllByPersonKeyAgeLessThanOrderBy(int ageLessThan);

    @Query("select p from Person p where p.personKey.name = :name and p.personKey.surname = :surname")
    Optional<List<Person>> findAllByPersonKeyNameAndPersonKeySurname(String name, String surname);
}
