package com.example.hibernate.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Person")
public class Person {
    @EmbeddedId
    PersonKey personKey;
    @Size(max = 14)
    @Column(nullable = false)
    String phoneNumber;
    @Size(max = 168)
    @Column(nullable = false, name = "city_of_living")
    String city;
}
