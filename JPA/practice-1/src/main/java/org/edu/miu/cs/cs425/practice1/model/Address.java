package org.edu.miu.cs.cs425.practice1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Address {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Street is required and cannot be blank.")
    private String street;

    @NotBlank(message = "City is required and cannot be blank.")
    private String city;

    @NotBlank(message = "State is required and cannot be blank.")
    private String state;

    @NotBlank(message = "Zip is required and cannot be blank.")
    private String zip;


}
