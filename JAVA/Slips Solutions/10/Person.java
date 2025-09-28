/*Q2. Create a package “utility”. Define a class CapitalString under “utility” package which will 
contain a method to return String with first letter capital. Create a Person class (members – name, 
city) outside the package. Display the person name with first letter as capital by making use of 
CapitalString. [20 Marks] */

import utility.CapitalString;
import java.util.Scanner;

public class Person {
    private String name;
    private String city;

    public Person(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public void display() {
        System.out.println("Name: " + CapitalString.capitalize(name));
        System.out.println("City: " + CapitalString.capitalize(city));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter city: ");
        String city = sc.nextLine();

        sc.close();

        Person p = new Person(name, city);
        p.display();
    }
}
