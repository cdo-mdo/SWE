package shoppingcart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import products.Product;

public class ShoppingCart {
    List<CartLine> cardLines = new ArrayList<>();

    public void action(Product product, String action) {
        if (action.equals("add")) {
            for (CartLine cardLine : cardLines) {
                if (cardLine.getProduct().getProductNumber().equals(product.getProductNumber())) {
                    cardLine.setNumber(cardLine.getNumber() + 1);
                    return;
                }
            }
            CartLine cardLine = new CartLine();
            cardLine.setProduct(product);
            cardLine.setNumber(1);
            cardLines.add(cardLine);
        } else {
            if (action.equals("remove")) {
                Iterator<CartLine> iter = cardLines.iterator();
                while (iter.hasNext()) {
                    CartLine cline = iter.next();
                    if (cline.getProduct().getProductNumber().equals(product.getProductNumber())) {
                        if (cline.getNumber() > 1) {
                            cline.setNumber(cline.getNumber() - 1);
                        } else {
                            iter.remove();
                        }
                    }
                }
            } else { //action is print
                System.out.println("Content of the shopping cart:");
                for (CartLine cardLine : cardLines) {
                    System.out.println(cardLine.getNumber() + " "
                            + cardLine.getProduct().getProductNumber() + " "
                            + cardLine.getProduct().getDescription() + " "
                            + cardLine.getProduct().getPrice());
                }
                System.out.println("Total price = " + getTotalPrice());
            }
        }
    }

    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (CartLine cardLine : cardLines) {
            totalPrice += (cardLine.getProduct().getPrice() * cardLine.getNumber());
        }
        return totalPrice;
    }
}
