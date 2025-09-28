import java.util.*;

class Vehicle {
    final String number;
    final String type;
    final long entryTime;

    Vehicle(String number, String type) {
        this.number = number;
        this.type = type;
        this.entryTime = System.currentTimeMillis();
    }
}

public class ParkingSystem {
    private final Map<String, Vehicle> parked = new HashMap<>();
    private final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new ParkingSystem().run();
    }

    void run() {
        int ch;
        do {
            System.out.println("\n1. Park Vehicle");
            System.out.println("2. Remove Vehicle");
            System.out.println("3. Show Parked");
            System.out.println("4. Exit");

            ch = Integer.parseInt(sc.nextLine());
            switch (ch) {
                case 1 -> park();
                case 2 -> remove();
                case 3 -> show();
            }
        } while (ch != 4);
    }

    void park() {
        String no = read("Vehicle Number: ");
        String type = read("Type: ");
        parked.put(no, new Vehicle(no, type));
        System.out.println("Parked.");
    }

    void remove() {
        String no = read("Vehicle Number: ");
        Vehicle v = parked.remove(no);
        if (v == null) {
            System.out.println("Not found.");
            return;
        }
        long dur = (System.currentTimeMillis() - v.entryTime) / 1000; // seconds
        double fee = dur * 2;
        System.out.println("Removed. Fee: ₹" + fee);
    }

    void show() {
        parked.values().forEach(x -> System.out.println(x.number + " " + x.type));
    }

    String read(String p) {
        System.out.print(p);
        return sc.nextLine();
    }
}
