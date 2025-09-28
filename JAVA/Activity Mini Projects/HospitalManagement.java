import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

class Patient {
    final String id;
    final String name;
    LocalDate admitDate;
    LocalDate dischargeDate;
    double perDayCharge;
    List<String> treatments = new ArrayList<>();

    Patient(String id, String name, LocalDate admitDate, double perDayCharge) {
        this.id = id;
        this.name = name;
        this.admitDate = admitDate;
        this.perDayCharge = perDayCharge;
    }

    void addTreatment(String t) {
        treatments.add(t);
    }

    void discharge(LocalDate d) {
        dischargeDate = d;
    }

    long daysStayed() {
        if (dischargeDate == null)
            return ChronoUnit.DAYS.between(admitDate, LocalDate.now()) + 1;
        return ChronoUnit.DAYS.between(admitDate, dischargeDate) + 1;
    }

    double bill() {
        return daysStayed() * perDayCharge + treatments.size() * 500;
    }

    public String toString() {
        return id + " " + name + " Days:" + daysStayed() + " Bill:₹" + bill();
    }
}

public class HospitalManagement {
    private final Map<String, Patient> patients = new HashMap<>();
    private final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new HospitalManagement().run();
    }

    void run() {
        int ch;
        do {
            System.out.println("\n1. Admit");
            System.out.println("2. Add Treatment");
            System.out.println("3. Discharge");
            System.out.println("4. Show");
            System.out.println("5. Exit");

            ch = Integer.parseInt(sc.nextLine());
            switch (ch) {
                case 1 -> admit();
                case 2 -> addTreatment();
                case 3 -> discharge();
                case 4 -> patients.values().forEach(System.out::println);
            }
        } while (ch != 5);
    }

    void admit() {
        String id = read("ID: ");
        String name = read("Name: ");
        patients.put(id, new Patient(id, name, LocalDate.now(), 2000));
        System.out.println("Admitted.");
    }

    void addTreatment() {
        String id = read("Patient ID: ");
        Patient p = patients.get(id);
        if (p == null) {
            System.out.println("No");
            return;
        }
        p.addTreatment(read("Treatment: "));
        System.out.println("Added.");
    }

    void discharge() {
        String id = read("Patient ID: ");
        Patient p = patients.get(id);
        if (p == null) {
            System.out.println("No");
            return;
        }
        p.discharge(LocalDate.now());
        System.out.println("Discharged. Bill: ₹" + p.bill());
    }

    String read(String p) {
        System.out.print(p);
        return sc.nextLine();
    }
}
