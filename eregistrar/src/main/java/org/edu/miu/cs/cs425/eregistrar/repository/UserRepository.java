package org.edu.miu.cs.cs425.eregistrar.repository;

import org.edu.miu.cs.cs425.eregistrar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
