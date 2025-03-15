package org.edu.miu.cs.cs425.eregistrar.repository;

import org.edu.miu.cs.cs425.eregistrar.model.Role;
import org.edu.miu.cs.cs425.eregistrar.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}
