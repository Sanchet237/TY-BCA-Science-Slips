import java.util.*;

class Calculator {
    private final List<String> history = new ArrayList<>();

    double add(double a, double b) {
        double r = a + b;
        history.add(a + " + " + b + " = " + r);
        return r;
    }

    double sub(double a, double b) {
        double r = a - b;
        history.add(a + " - " + b + " = " + r);
        return r;
    }

    double mul(double a, double b) {
        double r = a * b;
        history.add(a + " * " + b + " = " + r);
        return r;
    }

    double div(double a, double b) {
        double r = b == 0 ? Double.NaN : a / b;
        history.add(a + " / " + b + " = " + r);
        return r;
    }

    void printHistory() {
        history.forEach(System.out::println);
    }
}

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator c = new Calculator();

        int ch;
        do {
            System.out.println("\n1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. History");
            System.out.println("6. Exit");

            ch = Integer.parseInt(sc.nextLine());

            if (ch >= 1 && ch <= 4) {
                double a = readDouble(sc, "A: ");
                double b = readDouble(sc, "B: ");

                double res = switch (ch) {
                    case 1 -> c.add(a, b);
                    case 2 -> c.sub(a, b);
                    case 3 -> c.mul(a, b);
                    default -> c.div(a, b);
                };

                System.out.println("Result: " + res);
            } else if (ch == 5) {
                c.printHistory();
            }
        } while (ch != 6);
    }

    static double readDouble(Scanner sc, String p) {
        System.out.print(p);
        return Double.parseDouble(sc.nextLine());
    }
}
