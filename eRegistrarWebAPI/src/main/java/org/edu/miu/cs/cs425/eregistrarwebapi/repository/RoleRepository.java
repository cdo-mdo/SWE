package org.edu.miu.cs.cs425.eregistrarwebapi.repository;

import org.edu.miu.cs.cs425.eregistrarwebapi.model.Role;
import org.edu.miu.cs.cs425.eregistrarwebapi.model.RoleName;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}
