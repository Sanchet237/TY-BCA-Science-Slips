import java.util.*;

class Room {
    final int number;
    final String type;
    final double ratePerNight;
    boolean booked;

    Room(int number, String type, double rate) {
        this.number = number;
        this.type = type;
        this.ratePerNight = rate;
        this.booked = false;
    }

    @Override
    public String toString() {
        return number + " | " + type + " | ₹" + ratePerNight + " | " +
                (booked ? "Booked" : "Available");
    }
}

public class HotelBooking {
    private final Map<Integer, Room> rooms = new TreeMap<>();
    private final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new HotelBooking().run();
    }

    void run() {
        rooms.put(101, new Room(101, "Single", 1500));
        rooms.put(102, new Room(102, "Double", 2500));
        rooms.put(201, new Room(201, "Suite", 4500));

        int ch;
        do {
            System.out.println("\n1. Show Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Checkout");
            System.out.println("4. Exit");

            ch = Integer.parseInt(sc.nextLine());

            switch (ch) {
                case 1 -> rooms.values().forEach(System.out::println);
                case 2 -> book();
                case 3 -> checkout();
            }
        } while (ch != 4);
    }

    void book() {
        int no = readInt("Room number: ");
        Room r = rooms.get(no);

        if (r == null) {
            System.out.println("No such room.");
            return;
        }

        if (r.booked) {
            System.out.println("Already booked.");
            return;
        }

        int nights = readInt("Nights: ");
        r.booked = true;

        System.out.println("Booked. Total: ₹" + (r.ratePerNight * nights));
    }

    void checkout() {
        int no = readInt("Room number to checkout: ");
        Room r = rooms.get(no);

        if (r == null || !r.booked) {
            System.out.println("Not currently booked.");
            return;
        }

        r.booked = false;
        System.out.println("Checked out. Thank you!");
    }

    int readInt(String p) {
        System.out.print(p);
        return Integer.parseInt(sc.nextLine());
    }
}
