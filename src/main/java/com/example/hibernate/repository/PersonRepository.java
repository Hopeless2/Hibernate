package com.example.hibernate.repository;

import com.example.hibernate.model.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public String getPersonsByCity(String city) {
        Query query = entityManager.createQuery("select p from Person p where p.city = :cityname", Person.class);
        query.setParameter("cityname", city);
        var queryResultList = query.getResultList();
        StringBuilder stringBuilder = new StringBuilder();
        for (Object o : queryResultList) {
            stringBuilder.append(o.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}
