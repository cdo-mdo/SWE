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
@NoArgsConstructor
@AllArgsConstructor
public class Reserve {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;
    private LocalDate endDate;
    private double totalPrice;

    @ManyToOne
    @JoinColumn (nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn (nullable = false)
    private Car car;

    @OneToOne
    @JoinColumn (nullable = false)
    private Rental rental;

    @OneToOne (mappedBy = "reserve")
    private Payment payment;
}
