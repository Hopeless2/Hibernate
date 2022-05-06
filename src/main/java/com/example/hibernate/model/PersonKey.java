package com.example.hibernate.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class PersonKey implements Serializable {
    private static final long serialVersionUID = 4715277948551180798L;

    @Size(max = 255)
    private String name;
    @Size(max = 255)
    private String surname;
    @Max(150)
    private int age;
}
