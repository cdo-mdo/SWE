package org.edu.miu.cs.cs425.carrentalbackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String licensePlate;
    private int mileage;
    private CarStatus status;

    @ManyToOne
    @JoinColumn (nullable = false)
    private CarType carType;

    @OneToMany (mappedBy = "car")
    private List<Reserve> reserves;

    @OneToMany (mappedBy = "car")
    private List<Rental> rentals;
}
