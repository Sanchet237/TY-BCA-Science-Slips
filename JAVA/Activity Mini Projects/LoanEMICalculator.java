import java.util.*;

public class LoanEMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Loan Amount: ");
        double P = Double.parseDouble(sc.nextLine());
        System.out.print("Annual Rate (%): ");
        double r = Double.parseDouble(sc.nextLine()) / 12 / 100;
        System.out.print("Tenure (months): ");
        int n = Integer.parseInt(sc.nextLine());

        double emi = (P * r * Math.pow(1 + r, n)) / (Math.pow(1 + r, n) - 1);
        System.out.println("Monthly EMI: ₹" + String.format("%.2f", emi));
    }
}
