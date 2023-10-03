package com.data.models;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "Person")

public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Name shouldn't be empty")
    @Size(max = 50, message = "Name size should have maximum 50 characters")
    private String name;

    @Column(name = "age")
    @Min(value = 0, message = "Wrong statement for age")
    private int age;

    @Column(name = "email")
    @Size(max = 50, message = "Name size should have maximum 50 characters")
    @NotEmpty(message = "Email shouldn't be empty")
    @Email
    private String email;

}
