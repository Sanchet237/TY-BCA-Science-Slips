import java.util.*;

class Movie {
    final String name;
    final int rows, cols;
    final boolean[][] seats;
    final double price;

    Movie(String name, int rows, int cols, double price) {
        this.name = name;
        this.rows = rows;
        this.cols = cols;
        this.seats = new boolean[rows][cols];
        this.price = price;
    }

    int available() {
        int c = 0;
        for (boolean[] r : seats)
            for (boolean s : r)
                if (!s) c++;
        return c;
    }

    boolean book(int r, int c) {
        if (r < 1 || r > rows || c < 1 || c > cols) return false;
        if (seats[r - 1][c - 1]) return false;
        seats[r - 1][c - 1] = true;
        return true;
    }

    boolean cancel(int r, int c) {
        if (r < 1 || r > rows || c < 1 || c > cols) return false;
        if (!seats[r - 1][c - 1]) return false;
        seats[r - 1][c - 1] = false;
        return true;
    }

    void show() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                System.out.print(seats[i][j] ? "[X]" : "[ ]");
            System.out.println();
        }
    }

    public String toString() {
        return name + " Price:₹" + price + " Avail:" + available();
    }
}

public class CinemaBooking {
    private final Map<Integer, Movie> movies = new HashMap<>();
    private final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new CinemaBooking().run();
    }

    void run() {
        movies.put(1, new Movie("Avengers", 5, 8, 250));
        movies.put(2, new Movie("Comedy Night", 4, 6, 150));

        int ch;
        do {
            System.out.println("\n1. Show Movies");
            System.out.println("2. Show Seats");
            System.out.println("3. Book");
            System.out.println("4. Cancel");
            System.out.println("5. Exit");

            ch = Integer.parseInt(sc.nextLine());
            switch (ch) {
                case 1 -> movies.forEach((k, v) -> System.out.println(k + " - " + v));
                case 2 -> {
                    int id = readInt("Movie ID: ");
                    Movie m = movies.get(id);
                    if (m == null) System.out.println("Not found");
                    else m.show();
                }
                case 3 -> book();
                case 4 -> cancel();
            }
        } while (ch != 5);
    }

    void book() {
        int id = readInt("Movie ID: ");
        Movie m = movies.get(id);
        if (m == null) {
            System.out.println("No");
            return;
        }
        int r = readInt("Row: ");
        int c = readInt("Col: ");
        if (m.book(r, c)) System.out.println("Booked ₹" + m.price);
        else System.out.println("Failed");
    }

    void cancel() {
        int id = readInt("Movie ID: ");
        Movie m = movies.get(id);
        if (m == null) {
            System.out.println("No");
            return;
        }
        int r = readInt("Row: ");
        int c = readInt("Col: ");
        if (m.cancel(r, c)) System.out.println("Cancelled");
        else System.out.println("Failed");
    }

    int readInt(String p) {
        System.out.print(p);
        return Integer.parseInt(sc.nextLine());
    }
}
