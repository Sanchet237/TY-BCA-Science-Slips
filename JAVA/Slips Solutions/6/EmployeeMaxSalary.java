
/*Q2. Write a program which define class Employee with data member as id, name and salary Store 
the information of 'n' employees and Display the name of employee having maximum salary (Use 
array of object). [20 Marks] */

import java.util.*;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}

public class EmployeeMaxSalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine();

        Employee[] emp = new Employee[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1));
            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            emp[i] = new Employee(id, name, salary);
        }

        Employee maxEmp = emp[0];
        for (int i = 1; i < n; i++) {
            if (emp[i].salary > maxEmp.salary) {
                maxEmp = emp[i];
            }
        }

        System.out.println("\nEmployee with Maximum Salary:");
        System.out.println("Name: " + maxEmp.name + ", Salary: " + maxEmp.salary);
    }
}
