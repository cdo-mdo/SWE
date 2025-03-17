package org.edu.miu.cs.cs425.jpaonetoone.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public Employee(String name) {
        this.name = name;
    }

    @ManyToOne
    private Department department;

}
