import java.util.*;

class Customer {
    final String name;
    final String id;
    final int units;

    Customer(String id, String name, int units) {
        this.id = id;
        this.name = name;
        this.units = units;
    }
}

public class ElectricityBillCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Customer> customers = new ArrayList<>();

        System.out.print("How many customers? ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.print("ID: ");
            String id = sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Units: ");
            int u = Integer.parseInt(sc.nextLine());
            customers.add(new Customer(id, name, u));
        }

        for (Customer c : customers) {
            double bill = calculate(c.units);
            System.out.println(c.id + " " + c.name + " Units:" + c.units +
                               " Bill: ₹" + String.format("%.2f", bill));
        }
    }

    static double calculate(int units) {
        double amt = 0;
        if (units <= 50) amt = units * 3.5;
        else if (units <= 150) amt = 50 * 3.5 + (units - 50) * 4.0;
        else if (units <= 300) amt = 50 * 3.5 + 100 * 4.0 + (units - 150) * 5.2;
        else amt = 50 * 3.5 + 100 * 4.0 + 150 * 5.2 + (units - 300) * 6.5;
        double surcharge = amt * 0.12;
        return amt + surcharge;
    }
}
