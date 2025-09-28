/*Q2. Write a class Student with attributes roll no, name, age and course. Initialize values through 
parameterized constructor. If age of student is not in between 15 and 21 then generate user- 
defined exception ―Age Not Within The Range. [20 Marks]*/

class AgeNotWithinRangeException extends Exception {
    public AgeNotWithinRangeException(String message) {
        super(message);
    }
}

class Student {
    private int rollNo;
    private String name;
    private int age;
    private String course;

    public Student(int rollNo, String name, int age, String course) throws AgeNotWithinRangeException {
        if (age < 15 || age > 21) {
            throw new AgeNotWithinRangeException("Age Not Within The Range (15-21)");
        }
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
    }
}

public class StudentTest {
    public static void main(String[] args) {
        try {
            Student s1 = new Student(101, "Sanchet", 20, "BCA");
            s1.display();

            Student s2 = new Student(102, "Rahul", 14, "BCA");
            s2.display();
        } catch (AgeNotWithinRangeException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
