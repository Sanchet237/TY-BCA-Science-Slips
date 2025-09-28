import java.util.*;

class Student {
    final String id;
    final String name;
    final List<Course> courses = new ArrayList<>();

    Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    void enroll(Course c) {
        courses.add(c);
    }

    public String toString() {
        return id + " " + name + " Enrolled:" + courses.size();
    }
}

class Course {
    final String code;
    final String title;

    Course(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public String toString() {
        return code + " " + title;
    }
}

public class CourseRegistration {
    private final Map<String, Student> students = new HashMap<>();
    private final Map<String, Course> courses = new HashMap<>();
    private final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new CourseRegistration().run();
    }

    void run() {
        courses.put("CS101", new Course("CS101", "Java Basics"));
        courses.put("CS102", new Course("CS102", "Data Structures"));

        int ch;
        do {
            System.out.println("\n1. Add Student");
            System.out.println("2. Enroll Course");
            System.out.println("3. Show Students");
            System.out.println("4. Exit");

            ch = Integer.parseInt(sc.nextLine());
            switch (ch) {
                case 1 -> addStudent();
                case 2 -> enrollCourse();
                case 3 -> showStudents();
            }
        } while (ch != 4);
    }

    void addStudent() {
        String id = read("Student ID: ");
        String name = read("Name: ");
        students.put(id, new Student(id, name));
        System.out.println("Added.");
    }

    void enrollCourse() {
        String id = read("Student ID: ");
        Student s = students.get(id);
        if (s == null) {
            System.out.println("No student");
            return;
        }
        courses.forEach((k, v) -> System.out.println(k + " - " + v));
        String code = read("Course Code: ");
        Course c = courses.get(code);
        if (c == null) {
            System.out.println("No course");
            return;
        }
        s.enroll(c);
        System.out.println("Enrolled.");
    }

    void showStudents() {
        for (Student s : students.values()) {
            System.out.println(s);
            for (Course c : s.courses)
                System.out.println("  -> " + c);
        }
    }

    String read(String p) {
        System.out.print(p);
        return sc.nextLine();
    }
}
