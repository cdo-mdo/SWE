package org.edu.miu.cs.cs425.practice2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime dateOrder;
    private Double totalCostPrice;
    private Double totalTax;
    private Double totalAmountCharged;

    public Order(LocalDateTime dateOrder, Double totalCostPrice, Double totalTax, Double totalAmountCharged, Customer customer, Address shippingAddress) {
        this.dateOrder = dateOrder;
        this.totalCostPrice = totalCostPrice;
        this.totalTax = totalTax;
        this.totalAmountCharged = totalAmountCharged;
        this.customer = customer;
        this.shippingAddress = shippingAddress;
    }

    @ManyToOne
    @JoinColumn (name = "address_id")
    private Address shippingAddress;

    @ManyToOne
    @JoinColumn (name = "customer_id")
    private Customer customer;

    @OneToMany
    @JoinColumn (name = "order_id")
    private List<OrderItem> orderItems;



}
