/*Q2. Define a class SavingAccount (acno, name, balance). Define appropriate operations as, 
withdraw(), deposit(), and viewbalance(). The minimum balance must be 500. Create an object 
and perform operation. Raise user defined ―InsufficientFundException when balance is not 
sufficient for withdraw operation. [20 Marks]*/

class InsufficientFundException extends Exception {
    public InsufficientFundException(String message) {
        super(message);
    }
}

class SavingAccount {
    int acno;
    String name;
    double balance;
    final double MIN_BALANCE = 500;

    SavingAccount(int acno, String name, double balance) {
        this.acno = acno;
        this.name = name;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
        viewBalance();
    }

    void withdraw(double amount) throws InsufficientFundException {
        if (balance - amount < MIN_BALANCE) {
            throw new InsufficientFundException("Insufficient funds! Minimum balance 500 required.");
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount);
        viewBalance();
    }

    void viewBalance() {
        System.out.println("Current balance: " + balance);
    }
}

public class SavingAccountDemo {
    public static void main(String[] args) {
        SavingAccount acc = new SavingAccount(101, "Sanchet Kolekar", 1000);

        acc.viewBalance();
        acc.deposit(500);

        try {
            acc.withdraw(1200);
        } catch (InsufficientFundException e) {
            System.out.println(e.getMessage());
        }

        try {
            acc.withdraw(700);
        } catch (InsufficientFundException e) {
            System.out.println(e.getMessage());
        }
    }
}


