package org.edu.miu.cs.cs425.practice1.repository;

import org.edu.miu.cs.cs425.practice1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}