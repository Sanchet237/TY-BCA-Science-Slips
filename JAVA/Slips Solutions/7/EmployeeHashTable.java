// Q1. Create a Hash table containing Employee name and Salary. Display the details of the hash table. [10 Marks] 

import java.util.*;

public class EmployeeHashTable {
    public static void main(String[] args) {
        Hashtable<String, Double> employees = new Hashtable<>();

        employees.put("Sanchet", 75000.0);
        employees.put("Vaishnavi", 68000.0);
        employees.put("Urmila", 62000.0);
        employees.put("Dinesh", 70000.0);
        employees.put("Ajay", 65000.0);

        System.out.printf("%-5s %-15s %-10s%n", "S.No", "Name", "Salary");

        int srNo = 1;
        for (Map.Entry<String, Double> entry : employees.entrySet()) {
            System.out.printf("%-5d %-15s %-10.2f%n", srNo, entry.getKey(), entry.getValue());
            srNo++;
        }
    }
}
