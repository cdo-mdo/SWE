package org.edu.miu.cs.cs425.practice2.repository;

import org.edu.miu.cs.cs425.practice2.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Address, Integer> {
}