import java.util.*;

class Coach {
    final String name;
    final int seats;
    final boolean[] occupied;

    Coach(String name, int seats) {
        this.name = name;
        this.seats = seats;
        this.occupied = new boolean[seats];
    }

    int available() {
        int c = 0;
        for (boolean b : occupied) {
            if (!b) c++;
        }
        return c;
    }

    int bookFirstFree() {
        for (int i = 0; i < seats; i++) {
            if (!occupied[i]) {
                occupied[i] = true;
                return i + 1;
            }
        }
        return -1;
    }

    boolean cancel(int seatNo) {
        if (seatNo < 1 || seatNo > seats) return false;
        if (!occupied[seatNo - 1]) return false;
        occupied[seatNo - 1] = false;
        return true;
    }

    @Override
    public String toString() {
        return name + " Avail: " + available() + "/" + seats;
    }
}

public class RailwayReservation {
    private final Map<String, Coach> coaches = new LinkedHashMap<>();
    private final Map<String, List<String>> bookings = new HashMap<>();
    private final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new RailwayReservation().run();
    }

    void run() {
        coaches.put("A1", new Coach("A1-AC", 10));
        coaches.put("SL1", new Coach("SL1-Sleeper", 20));

        int ch;
        do {
            System.out.println("\n1. Show Coaches");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. My Bookings");
            System.out.println("5. Exit");

            ch = Integer.parseInt(sc.nextLine());

            switch (ch) {
                case 1 -> showCoaches();
                case 2 -> bookTicket();
                case 3 -> cancelTicket();
                case 4 -> myBookings();
            }
        } while (ch != 5);
    }

    void showCoaches() {
        coaches.values().forEach(System.out::println);
    }

    void bookTicket() {
        String coachId = read("Coach ID: ");
        Coach c = coaches.get(coachId);

        if (c == null) {
            System.out.println("Invalid coach.");
            return;
        }

        int seat = c.bookFirstFree();
        if (seat < 0) {
            System.out.println("No seats.");
            return;
        }

        String pName = read("Passenger name: ");
        bookings.computeIfAbsent(pName, k -> new ArrayList<>()).add(coachId + "#" + seat);

        System.out.println("Booked seat " + seat + " in " + coachId);
    }

    void cancelTicket() {
        String coachId = read("Coach ID: ");
        int seat = Integer.parseInt(read("Seat no: "));
        Coach c = coaches.get(coachId);

        if (c == null) {
            System.out.println("Invalid coach.");
            return;
        }

        if (c.cancel(seat)) {
            System.out.println("Cancelled.");
            removeBookingEntry(coachId, seat);
        } else {
            System.out.println("Cancel failed.");
        }
    }

    void removeBookingEntry(String coachId, int seat) {
        for (List<String> list : bookings.values()) {
            list.removeIf(s -> s.equals(coachId + "#" + seat));
        }
    }

    void myBookings() {
        String name = read("Passenger name: ");
        List<String> b = bookings.getOrDefault(name, Collections.emptyList());

        if (b.isEmpty()) {
            System.out.println("No bookings.");
        } else {
            b.forEach(System.out::println);
        }
    }

    String read(String p) {
        System.out.print(p);
        return sc.nextLine();
    }
}
