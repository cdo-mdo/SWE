package org.edu.miu.cs.cs425.carrentalbackend.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee extends Person {
    private EmployeeRole role;
}
