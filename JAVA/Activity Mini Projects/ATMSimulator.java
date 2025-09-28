import java.util.*;

class Account {
    private static int nextId = 1001;
    private final int id;
    private final String name;
    private double balance;

    Account(String name, double initial) {
        this.id = nextId++;
        this.name = name;
        this.balance = Math.max(0, initial);
    }

    public int getId() { return id; }

    public String getName() { return name; }

    public double getBalance() { return balance; }

    public boolean deposit(double amt) {
        if (amt <= 0) return false;
        balance += amt;
        return true;
    }

    public boolean withdraw(double amt) {
        if (amt <= 0 || amt > balance) return false;
        balance -= amt;
        return true;
    }

    @Override
    public String toString() {
        return String.format("Account[%d] %s - ₹%.2f", id, name, balance);
    }
}

public class ATMSimulator {
    private static final Scanner sc = new Scanner(System.in);
    private final List<Account> accounts = new ArrayList<>();

    public static void main(String[] args) {
        new ATMSimulator().run();
    }

    void run() {
        seed();
        int choice;

        do {
            menu();
            choice = readInt("Choice: ");

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> operateAccount();
                case 3 -> listAccounts();
                case 4 -> System.out.println("Bye!");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }

    void seed() {
        accounts.add(new Account("Amit", 5000));
        accounts.add(new Account("Reena", 2500));
    }

    void menu() {
        System.out.println("\n--- ATM MENU ---");
        System.out.println("1. Create Account");
        System.out.println("2. Use Account (check/deposit/withdraw)");
        System.out.println("3. List Accounts");
        System.out.println("4. Exit");
    }

    void createAccount() {
        String name = readStr("Name: ");
        double init = readDouble("Initial deposit: ");

        Account a = new Account(name, init);
        accounts.add(a);

        System.out.println("Created: " + a);
    }

    void operateAccount() {
        int id = readInt("Account ID: ");
        Account a = findAccount(id);

        if (a == null) {
            System.out.println("Not found.");
            return;
        }

        int ch;
        do {
            System.out.println("\n" + a);
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Back");

            ch = readInt("Choice: ");

            switch (ch) {
                case 1 -> System.out.println("Balance: ₹" + a.getBalance());
                case 2 -> {
                    double amt = readDouble("Deposit amount: ");
                    if (a.deposit(amt)) System.out.println("Deposited.");
                    else System.out.println("Invalid amount.");
                }
                case 3 -> {
                    double amt = readDouble("Withdraw amount: ");
                    if (a.withdraw(amt)) System.out.println("Withdrawn.");
                    else System.out.println("Failed: insufficient or invalid.");
                }
            }
        } while (ch != 4);
    }

    Account findAccount(int id) {
        return accounts.stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElse(null);
    }

    void listAccounts() {
        accounts.forEach(System.out::println);
    }

    static int readInt(String p) {
        System.out.print(p);
        return sc.nextInt();
    }

    static double readDouble(String p) {
        System.out.print(p);
        return sc.nextDouble();
    }

    static String readStr(String p) {
        System.out.print(p);
        sc.nextLine(); 
        return sc.nextLine();
    }
}
