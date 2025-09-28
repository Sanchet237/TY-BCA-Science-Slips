/*Q2. Write a program to create a super class Employee (members – name, salary). Derive a sub- class 
as Developer (member – projectname). Create object of Developer and display the detailsof it. 
[20 Marks] */

class Employee {
    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}

class Developer extends Employee {
    private String projectName;

    public Developer(String name, double salary, String projectName) {
        super(name, salary);
        this.projectName = projectName;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
        System.out.println("Project Name: " + projectName);
    }
}

public class EmployeeTest {
    public static void main(String[] args) {
        Developer dev = new Developer("Sanchet", 50000, "AI Powered HelpDesk");
        dev.display();
    }
}
