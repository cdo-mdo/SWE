package org.edu.miu.cs.cs425.carrentalbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceRecord {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate lastMaintenanceDate;
    private LocalTime nextMaintenanceTime;

    @OneToMany (mappedBy = "maintenanceRecord", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Repair> repairs;
}
