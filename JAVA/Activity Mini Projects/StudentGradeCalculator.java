import java.util.*;

class Student {
    int id;
    String name;
    List<Integer> marks;

    Student(int id, String name, List<Integer> marks) {
        this.id = id;
        this.name = name;
        this.marks = new ArrayList<>(marks);
    }

    double average() {
        return marks.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    char grade() {
        double a = average();
        return a >= 90 ? 'A' :
               a >= 75 ? 'B' :
               a >= 60 ? 'C' :
               a >= 50 ? 'D' : 'F';
    }

    @Override
    public String toString() {
        return id + " " + name +
               " Avg:" + String.format("%.2f", average()) +
               " Grade:" + grade();
    }
}

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        System.out.print("How many students? ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("How many subjects? ");
            int s = Integer.parseInt(sc.nextLine());

            List<Integer> marks = new ArrayList<>();
            for (int j = 0; j < s; j++) {
                System.out.print("Mark " + (j + 1) + ": ");
                marks.add(Integer.parseInt(sc.nextLine()));
            }

            students.add(new Student(i + 1, name, marks));
        }

        System.out.println("\n--- Report ---");
        students.forEach(System.out::println);

        double classAvg = students.stream()
                .mapToDouble(Student::average)
                .average()
                .orElse(0);

        System.out.println("Class Average: " + String.format("%.2f", classAvg));
        sc.close();
    }
}
