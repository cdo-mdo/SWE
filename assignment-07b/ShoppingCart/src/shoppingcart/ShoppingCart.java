package shoppingcart;

import java.util.*;

import products.Product;

public class ShoppingCart {
    Map<Product, Integer> products = new HashMap<>();

    public void addProduct(Product product, int quantity) {
        products.put(product, products.getOrDefault(product, 0) + quantity);
    }

    public void addProduct(Product product) {
        products.put(product, products.getOrDefault(product, 0) + 1);
    }

    public void removeProduct(Product product) {
        if (!products.containsKey(product)) {
            return;
        }

        int count = products.get(product);
        if (count > 1) {
            products.put(product, count - 1);
        }
        else {
            products.remove(product);
        }
    }

    public void print() {
        System.out.println("Content of the shopping cart:");
        double totalPrice = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            totalPrice += product.getPrice();
            System.out.println(entry.getValue() + " "
                    + product.getProductNumber() + " "
                    + product.getDescription() + " "
                    + product.getPrice());
        }
        System.out.println("Total price: " + totalPrice);
    }
}
