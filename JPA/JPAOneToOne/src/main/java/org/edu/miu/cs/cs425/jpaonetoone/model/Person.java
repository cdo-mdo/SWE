package org.edu.miu.cs.cs425.jpaonetoone.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Person(String name) {
        this.name = name;
    }

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "account_id")
    private Account account;
}
