/* Q2. Write a program to accept details of 'n' customers (c_id, cname, address, mobile_no) from 
user and store it in a file using DataOutputStream class. [20 Marks] */

import java.io.*;
import java.util.Scanner;

public class CustomerDataFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of customers: ");
        int n = sc.nextInt();
        sc.nextLine();

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("customers.txt"))) {
            for (int i = 0; i < n; i++) {
                System.out.println("\nEnter details for customer " + (i + 1) + ":");

                System.out.print("Customer ID: ");
                int c_id = sc.nextInt();
                sc.nextLine();

                System.out.print("Name: ");
                String cname = sc.nextLine();

                System.out.print("Address: ");
                String address = sc.nextLine();

                System.out.print("Mobile No: ");
                String mobile_no = sc.nextLine();

                dos.writeInt(c_id);
                dos.writeUTF(cname);
                dos.writeUTF(address);
                dos.writeUTF(mobile_no);
            }
            System.out.println("\nCustomer details saved to 'customers.txt' successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
