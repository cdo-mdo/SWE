package org.edu.miu.cs.cs425.carrentalbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rental {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;
    private LocalDate endDate;
    private String pickupLocation;
    private String dropOffLocation;

    @ManyToOne
    @JoinColumn (nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn (nullable = false)
    private Car car;

    @OneToOne (mappedBy = "rental")
    private Reserve reserve;

    @OneToOne (mappedBy = "rental")
    private Payment payment;
}
