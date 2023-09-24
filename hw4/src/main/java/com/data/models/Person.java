package com.data.models;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Entity
@Table

public class Person {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Name shouldn't be empty")
    @Size(max = 50, message = "Name size should have maximum 50 characters")
    private String name;
    @Min(value = 0, message = "Wrong statement for age")
    private int age;
    @NotEmpty(message = "Email shouldn't be empty")
    @Email
    private String email;

}
