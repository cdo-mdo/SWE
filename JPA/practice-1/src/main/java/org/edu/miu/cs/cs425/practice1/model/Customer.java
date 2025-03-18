package org.edu.miu.cs.cs425.practice1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Customer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "First name is required and cannot be blank.")
    private String firstName;

    @NotBlank(message = "Last name is required and cannot be blank.")
    private String lastName;

    @OneToOne
    @JoinColumn (name = "customer_id")
    private Address address;
}
