/*Q2. Create an abstract class “order” having members id, description. Create a subclass 
“Purchase Order” having member as customer name. Define methods accept and display. 
Create 3 objects each of Purchase Order. Accept and display the details. 
[20 Marks] */


import java.util.Scanner;

abstract class Order {
    int id;
    String description;

    abstract void accept();
    abstract void display();
}

class PurchaseOrder extends Order {
    String customerName;
    Scanner sc = new Scanner(System.in);

    void accept() {
        System.out.print("Enter Order ID: ");
        id = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter Description: ");
        description = sc.nextLine();

        System.out.print("Enter Customer Name: ");
        customerName = sc.nextLine();
    }

    void display() {
        System.out.println("\nOrder ID: " + id);
        System.out.println("Description: " + description);
        System.out.println("Customer Name: " + customerName);
    }
}

public class PurchaseOrderDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PurchaseOrder[] orders = new PurchaseOrder[3];

        System.out.println("Enter details for 3 Purchase Orders:");
        for (int i = 0; i < 3; i++) {
            System.out.println("\n--- Order " + (i + 1) + " ---");
            orders[i] = new PurchaseOrder();
            orders[i].accept();
        }

        System.out.println("\n===== Purchase Order Details =====");
        for (int i = 0; i < 3; i++) {
            System.out.println("\n--- Order " + (i + 1) + " ---");
            orders[i].display();
        }

        sc.close();
    }
}
