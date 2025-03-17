package org.edu.miu.cs.cs425.eregistrarwebapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private RoleName name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role(RoleName roleName) {
        this.name = roleName;
    }

    public String name() {
        return name.toString();
    }

    // Getters and Setters
}
