package org.edu.miu.cs.cs425.eregistrar.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
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
}
