/*Q2. Write a class Student with attributes roll no, name, age and course. Initialize values through 
parameterized constructor. If student's roll no of is not in between 13001 to 13080 thengenerate 
user- defined exception ―Rollno is Not Within The Range. [20 Marks] */

class RollNoNotWithinRangeException extends Exception {
    public RollNoNotWithinRangeException(String message) {
        super(message);
    }
}

class Student {
    private int rollNo;
    private String name;
    private int age;
    private String course;

    public Student(int rollNo, String name, int age, String course) throws RollNoNotWithinRangeException {
        if (rollNo < 13001 || rollNo > 13080) {
            throw new RollNoNotWithinRangeException("Roll No Not Within The Range (13001-13080)");
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

// Main class
public class StudentTest {
    public static void main(String[] args) {
        try {
            Student s1 = new Student(13005, "Sanchet", 22 "BCA");
            s1.display();

            Student s2 = new Student(13085, "Rahul",21,"BCA");
            s2.display();

        } catch (RollNoNotWithinRangeException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
