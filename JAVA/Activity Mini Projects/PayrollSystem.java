import java.util.*;

class Employee {
    final int id;
    final String name;
    double basic;
    double pfPercent;
    double taxPercent;

    Employee(int id, String name, double basic, double pf, double tax) {
        this.id = id;
        this.name = name;
        this.basic = basic;
        this.pfPercent = pf;
        this.taxPercent = tax;
    }

    double gross() { return basic; }

    double pf() { return gross() * pfPercent / 100; }

    double tax() { return (gross() - pf()) * taxPercent / 100; }

    double net() { return gross() - pf() - tax(); }

    @Override
    public String toString() {
        return id + " " + name +
                " Gross: ₹" + gross() +
                " Net: ₹" + String.format("%.2f", net());
    }
}

public class PayrollSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee> emps = new ArrayList<>();

        emps.add(new Employee(1, "Sanjay", 50000, 12, 10));
        emps.add(new Employee(2, "Meera", 30000, 10, 8));

        int ch;
        do {
            System.out.println("\n1. List Employees");
            System.out.println("2. Add Employee");
            System.out.println("3. Show PaySlip");
            System.out.println("4. Exit");

            ch = Integer.parseInt(sc.nextLine());

            switch (ch) {
                case 1 -> emps.forEach(System.out::println);

                case 2 -> {
                    System.out.print("Name: ");
                    String n = sc.nextLine();

                    System.out.print("Basic: ");
                    double b = Double.parseDouble(sc.nextLine());

                    System.out.print("PF%: ");
                    double pf = Double.parseDouble(sc.nextLine());

                    System.out.print("Tax%: ");
                    double t = Double.parseDouble(sc.nextLine());

                    emps.add(new Employee(emps.size() + 1, n, b, pf, t));
                }

                case 3 -> {
                    int id = Integer.parseInt(read(sc, "Employee ID: "));
                    emps.stream()
                        .filter(e -> e.id == id)
                        .findFirst()
                        .ifPresentOrElse(
                            e -> {
                                System.out.println("Payslip for " + e.name);
                                System.out.println("Basic: ₹" + e.basic);
                                System.out.println("PF: ₹" + String.format("%.2f", e.pf()));
                                System.out.println("Tax: ₹" + String.format("%.2f", e.tax()));
                                System.out.println("Net Pay: ₹" + String.format("%.2f", e.net()));
                            },
                            () -> System.out.println("Not found.")
                        );
                }
            }
        } while (ch != 4);
    }

    static String read(Scanner sc, String p) {
        System.out.print(p);
        return sc.nextLine();
    }
}
