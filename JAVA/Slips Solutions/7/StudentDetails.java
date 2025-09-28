/*Q2. Define a class student having rollno, name and percentage. Define Default and 
parameterized constructor. Accept the 5 student details and display it. (Use this keyword). 
[20 Marks] */

import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    double percentage;

    Student() {
        this.rollNo = 0;
        this.name = "Unknown";
        this.percentage = 0.0;
    }

    Student(int rollNo, String name, double percentage) {
        this.rollNo = rollNo;
        this.name = name;
        this.percentage = percentage;
    }

    void display() {
        System.out.printf("%-5d %-15s %-10.2f%n", this.rollNo, this.name, this.percentage);
    }
}

public class StudentDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[5];

        System.out.println("Enter details of 5 students:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Student " + (i + 1) + ":");
            System.out.print("Roll No: ");
            int roll = sc.nextInt();
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Percentage: ");
            double percent = sc.nextDouble();

            students[i] = new Student(roll, name, percent);
        }

        System.out.printf("%-5s %-15s %-10s%n", "Roll", "Name", "Percentage");

        for (Student s : students) {
            s.display();
        }

        sc.close();
    }
}
