package org.edu.miu.cs.cs425.practice1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate dateOrdered;
    private Double totalCostPrice;
    private Double totalTax;
    private Double totalAmountCharged;

//    @OneToMany
//    List<OrderItem> orderItems;
//
//    @OneToOne
//    private Address shippingAddress;
//
//    @ManyToOne
//    private Customer customer;
}
