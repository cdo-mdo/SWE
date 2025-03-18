package org.edu.miu.cs.cs425.practice2;

import org.edu.miu.cs.cs425.practice2.model.Category;
import org.edu.miu.cs.cs425.practice2.model.Product;
import org.edu.miu.cs.cs425.practice2.model.Customer;
import org.edu.miu.cs.cs425.practice2.model.Address;
import org.edu.miu.cs.cs425.practice2.model.Order;
import org.edu.miu.cs.cs425.practice2.model.OrderItem;
import org.edu.miu.cs.cs425.practice2.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Component
public class DataInitialization implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DataInitialization(CustomerRepository customerRepository,
                              AddressRepository addressRepository,
                              OrderRepository orderRepository,
                              OrderItemRepository orderItemRepository,
                              ProductRepository productRepository,
                              CategoryRepository categoryRepository) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) {
        // Create Categories
        Category electronics = new Category("Electronics");
        Category appliances = new Category("Home Appliances");
//        categoryRepository.save(electronics);
//        categoryRepository.save(appliances);

        // Create Products and assign categories
        Product laptop = new Product("Laptop", "laptop", Set.of(electronics));
        Product smartphone = new Product("Smartphone", "smartphone", Set.of(electronics));
        Product refrigerator = new Product("Refrigerator", "refrigerator", Set.of(appliances));
        productRepository.saveAll(List.of(laptop, smartphone, refrigerator));

        // Create Address
        Address address1 = new Address("123 Main St", "New York", "NY", "10001");
        Address address2 = new Address("456 Elm St", "Boston", "MA", "02108");
        addressRepository.saveAll(List.of(address1, address2));

        // Create Customers
        Customer customer1 = new Customer("Alice", "Johnson", address1);
        Customer customer2 = new Customer("Bob", "Smith", address2);
        customerRepository.saveAll(List.of(customer1, customer2));

        // Create Orders
        Order order1 = new Order(LocalDateTime.now(), 1800.0, 100.0, 1900.0,  customer1, address1);
        Order order2 = new Order(LocalDateTime.now(), 1500.0, 100.0, 1600.0, customer2, address2);
        orderRepository.saveAll(List.of(order1, order2));

        // Create OrderItems and associate with Orders
        OrderItem orderItem1 = new OrderItem("Laptop", 1, 1000.0, order1);
        OrderItem orderItem2 = new OrderItem("Smartphone", 1, 800.0, order1);
        OrderItem orderItem3 = new OrderItem("Refrigerator", 1, 1500.0, order2);
        orderItemRepository.saveAll(List.of(orderItem1, orderItem2, orderItem3));

        // Associate order items with orders and save
        order1.setOrderItems(List.of(orderItem1, orderItem2));
        order2.setOrderItems(List.of(orderItem3));
        orderRepository.saveAll(List.of(order1, order2));

        // Logging inserted data
        System.out.println("📦 Sample data has been initialized successfully!");
    }
}

