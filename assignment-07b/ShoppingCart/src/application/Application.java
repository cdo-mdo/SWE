package application;

import products.Product;
import shoppingcart.ShoppingCart;

public class Application {

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Product p1 = new Product("A123", 100.0, "TV");
        cart.addProduct(p1);
        Product p2 = new Product("A665", 75.0, "MP3 Player");
        cart.addProduct(p2, 1);
        Product p3 = new Product("A665", 75.0, "MP3 Player");
        cart.addProduct(p3, 1);

        cart.print();

        cart.removeProduct(p3);
        cart.removeProduct(p2);

        cart.print();

    }

}
