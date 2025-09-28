import java.time.*;
import java.util.*;

class Pass {
    final String passId;
    final String owner;
    LocalDate validTill;

    Pass(String passId, String owner, LocalDate validTill) {
        this.passId = passId;
        this.owner = owner;
        this.validTill = validTill;
    }

    boolean isValid() {
        return LocalDate.now().isBefore(validTill) || LocalDate.now().isEqual(validTill);
    }

    void renew(int months) {
        validTill = validTill.plusMonths(months);
    }

    public String toString() {
        return passId + " " + owner + " ValidTill:" + validTill +
               " (" + (isValid() ? "Valid" : "Expired") + ")";
    }
}

public class BusPassManagement {
    private final Map<String, Pass> passes = new HashMap<>();
    private final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new BusPassManagement().run();
    }

    void run() {
        passes.put("BP1001", new Pass("BP1001", "Rita", LocalDate.now().plusMonths(6)));

        int ch;
        do {
            System.out.println("\n1. Issue");
            System.out.println("2. Check Validity");
            System.out.println("3. Renew");
            System.out.println("4. List");
            System.out.println("5. Exit");

            ch = Integer.parseInt(sc.nextLine());
            switch (ch) {
                case 1 -> issue();
                case 2 -> check();
                case 3 -> renew();
                case 4 -> passes.values().forEach(System.out::println);
            }
        } while (ch != 5);
    }

    void issue() {
        String id = read("Pass ID: ");
        String owner = read("Owner: ");
        int m = Integer.parseInt(read("Months validity: "));
        passes.put(id, new Pass(id, owner, LocalDate.now().plusMonths(m)));
        System.out.println("Issued.");
    }

    void check() {
        String id = read("Pass ID: ");
        Pass p = passes.get(id);
        if (p == null) System.out.println("No");
        else System.out.println(p + " Valid: " + p.isValid());
    }

    void renew() {
        String id = read("Pass ID: ");
        Pass p = passes.get(id);
        if (p == null) System.out.println("No");
        else {
            int m = Integer.parseInt(read("Months: "));
            p.renew(m);
            System.out.println("Renewed to " + p.validTill);
        }
    }

    String read(String p) {
        System.out.print(p);
        return sc.nextLine();
    }
}
