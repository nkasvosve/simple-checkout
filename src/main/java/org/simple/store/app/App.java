package org.simple.store.app;

import org.simple.store.model.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Order order = new Order();

        while (true) {
            int count = 0;
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nCase does not matter");
            System.out.println("Please enter A for Apple, O for Orange, C for checkout or Q to exit");
            String input = scanner.next();

            if (input == null) {
                continue;
            }
            input = input.trim();
            char ch = input.charAt(0);

            String actual = String.valueOf(ch).toUpperCase();

            if (actual.equals("Q")){
                System.exit(0);
            }

            if (actual.equals("A") || actual.equals("O")) {
                while(true) {
                    try {
                        System.out.println("Please enter the count, or CONTL-C to exit");
                        count = scanner.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input entered for count. Please try again");
                    }
                }
            }

            switch (actual) {
                case "A":
                    addProduct(order, ProductType.APPLE, count);
                    printOrder(order);
                    break;
                case "O":
                    addProduct(order, ProductType.ORANGE, count);
                    printOrder(order);
                    break;
                case "C":
                    printOrder(order);

                    break;
                case "Q":
                    System.exit(0);
            }
        }

    }

    private static void printOrder(Order order) {
        System.out.println(order);
    }

    private static void addProduct(Order order, ProductType productType, int count) {
        Product product = new Product();
        product.setProductType(productType);
        product.setPrice(Constants.PRICES.get(productType));
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setCount(count);
        order.addOrderItem(orderItem);
    }
}
