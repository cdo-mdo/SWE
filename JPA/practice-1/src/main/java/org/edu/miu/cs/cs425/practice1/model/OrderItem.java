package org.edu.miu.cs.cs425.practice1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double quantity;
    private Double unitPrice;
    private Double costPrice;

    @ManyToOne
    @JoinColumn (name = "product_id")
    private Product product;
}
