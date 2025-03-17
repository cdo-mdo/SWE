package org.edu.miu.cs.cs425.jpaonetoone.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Department(String name) {
        this.name = name;
        employees = new ArrayList<>();
    }

    public Department(String name, Employee employee) {
        this(name);
        this.employees.add(employee);
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn (name = "department_id")
    private List<Employee> employees;

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
}
