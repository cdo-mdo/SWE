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
public class Repair {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate repairDate;
    private String repairReason;
    private double totalCost;

    @ManyToOne
    @JoinColumn (nullable = false)
    private MaintenanceRecord maintenanceRecord;
}
