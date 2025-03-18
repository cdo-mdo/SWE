package org.edu.miu.cs.cs425.practice1.repository;

import jakarta.persistence.criteria.Order;
import org.edu.miu.cs.cs425.practice1.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}
