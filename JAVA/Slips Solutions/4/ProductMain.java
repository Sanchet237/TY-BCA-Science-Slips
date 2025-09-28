/* Q2. Write a program which defines class Product with data members as id, name, and price. 
Store the information of 5 products and display the name of product having minimum price.*/

import java.util.*;

class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class ProductMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Product[] products = new Product[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("\nEnter details for Product " + (i + 1) + ":");
            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine(); 
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();

            products[i] = new Product(id, name, price);
        }

        Product minProduct = products[0];
        for (int i = 1; i < products.length; i++) {
            if (products[i].price < minProduct.price) {
                minProduct = products[i];
            }
        }

        System.out.println("\nProduct with minimum price: " + minProduct.name);

        sc.close();
    }
}
 