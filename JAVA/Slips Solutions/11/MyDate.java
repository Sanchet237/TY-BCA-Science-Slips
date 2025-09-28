/*Q1. Write a program create class as MyDate with dd,mm,yy as data members. Write 
parameterized constructor. Display the date in dd-mm-yy format. (Use this keyword) 
[10 Marks]*/

import java.util.Scanner;

class MyDate {
    int dd, mm, yy;

    MyDate(int dd, int mm, int yy) {
        this.dd = dd;
        this.mm = mm;
        this.yy = yy;
    }

    void displayDate() {
        System.out.printf("%02d-%02d-%04d\n", dd, mm, yy);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter day (dd): ");
        int day = scanner.nextInt();
        System.out.print("Enter month (mm): ");
        int month = scanner.nextInt();
        System.out.print("Enter year (yy): ");
        int year = scanner.nextInt();

        MyDate Date = new MyDate(day, month, year);

        Date.displayDate();

        scanner.close();
    }
}