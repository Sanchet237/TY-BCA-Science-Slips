/*Q2. Write acc program to create class Account (accno, accname, balance). Create an array of 'n' 
Account objects. Define static method “sortAccount” which sorts the array on the basis of balance. 
Display account details in sorted order. [20 Marks] */

import java.util.*;

class Account {
    int accno;
    String accname;
    double balance;

    Account(int accno, String accname, double balance) {
        this.accno = accno;
        this.accname = accname;
        this.balance = balance;
    }

    public static void sortAccount(Account[] acc) {
        for (int i = 0; i < acc.length - 1; i++) {
            for (int j = i + 1; j < acc.length; j++) {
                if (acc[i].balance > acc[j].balance) {
                    Account temp = acc[i];
                    acc[i] = acc[j];
                    acc[j] = temp;
                }
            }
        }
    }

    public void display() {
        System.out.println("Acc No: " + accno + ", Name: " + accname + ", Balance: " + balance);
    }
}

public class AccountMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of acc: ");
        int n = sc.nextInt();

        Account[] acc = new Account[n];

        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter Account No: ");
            int accno = sc.nextInt();
            sc.nextLine(); // clear buffer

            System.out.print("Enter Account Name: ");
            String accname = sc.nextLine();

            System.out.print("Enter Balance: ");
            double balance = sc.nextDouble();

            acc[i] = new Account(accno, accname, balance);
        }

        Account.sortAccount(acc);

        System.out.println("\nAccounts sorted by Balance:");
        for (Account a : acc) {
            a.display();
        }

        sc.close();
    }
}
