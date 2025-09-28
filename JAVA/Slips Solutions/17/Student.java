/*Q2. Define a class Student with attributes rollno and name. Define default and parameterized 
constructor. Keep the count of Objects created. Create objects using parameterized constructor and 
Display the object count after each object is created. [20 Marks]  */

public class Student {
    private int rollno;
    private String name;
    private static int objCnt = 0;

    public Student() {
        rollno = 0;
        name = "Unknown";
        objCnt++;
    }

    public Student(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
        objCnt++;
    }

    public static int getObjectCount() {
        return objCnt;
    }

    public static void main(String[] args) {
        Student s1 = new Student(1, "Sanchet");
        System.out.println("Object count: " + Student.getObjectCount());

        Student s2 = new Student(2, "Pritam");
        System.out.println("Object count: " + Student.getObjectCount());

        Student s3 = new Student();
        System.out.println("Object count: " + Student.getObjectCount());
    }
}
