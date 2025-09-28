/*Q2. Create an employee class (id,name,deptname,salary). Define a default and parameterized 
constructor. Use ‘this’ keyword to initialize instance variables. Keep a count of objects created. 
Create objects using parameterized constructor and display the object count after each object is 
created. Also display the contents of each object. [20 Marks]  */

import java.util.Scanner;

class Employee {
    int id;
    String name;
    String dept;
    double salary;
    static int count = 0;

    Employee(int id, String name, String dept, double salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        count++;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Dept: " + dept + ", Salary: " + salary);
    }

    static void showCount() {
        System.out.println("Objects created: " + count);
    }
}

public class EmployeeMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine();

        Employee[] emp = new Employee[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for employee " + (i+1) + ":");
            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine(); 
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Department: ");
            String dept = sc.nextLine();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();

            emp[i] = new Employee(id, name, dept, salary);
            emp[i].display();
            Employee.showCount();
        }

        sc.close();
    }
}
