package org.edu.miu.cs.cs425.carrentalbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String password;

    @OneToOne (mappedBy = "account")
    private Person person;

    @OneToMany (mappedBy = "account")
    private List<Reserve> reserves;

    @OneToMany (mappedBy = "account")
    private List<Rental> rentals;
}
