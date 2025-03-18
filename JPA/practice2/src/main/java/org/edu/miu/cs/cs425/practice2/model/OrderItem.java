package org.edu.miu.cs.cs425.practice2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double quantity;
    private Double unitPrice;
    private Double costPrice;

    public OrderItem(Double quantity, Double unitPrice, Double costPrice) {
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.costPrice = costPrice;
    }

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
