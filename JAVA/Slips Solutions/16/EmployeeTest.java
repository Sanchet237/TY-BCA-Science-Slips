/*Q2. Write a program to create a super class Employee (members – name, salary). Derive a sub- class 
Programmer (member – proglanguage). Create object of Programmer and display the details of it. 
[20 Marks] */

class Employee {
    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}

class Programmer extends Employee {
    private String progLanguage;

    public Programmer(String name, double salary, String progLanguage) {
        super(name, salary);
        this.progLanguage = progLanguage;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
        System.out.println("Programming Language: " + progLanguage);
    }
}

public class EmployeeTest {
    public static void main(String[] args) {
        Programmer prog = new Programmer("Sanchet", 55000, "Java");
        prog.display();
    }
}
