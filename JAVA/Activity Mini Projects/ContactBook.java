import java.util.*;

class Contact {
    final String name;
    final String phone;

    Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String toString() {
        return name + " - " + phone;
    }
}

public class ContactBook {
    private final List<Contact> contacts = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new ContactBook().run();
    }

    void run() {
        int ch;
        do {
            System.out.println("\n1. Add Contact");
            System.out.println("2. Search");
            System.out.println("3. Show All");
            System.out.println("4. Exit");

            ch = Integer.parseInt(sc.nextLine());
            switch (ch) {
                case 1 -> add();
                case 2 -> search();
                case 3 -> contacts.forEach(System.out::println);
            }
        } while (ch != 4);
    }

    void add() {
        String name = read("Name: ");
        String phone = read("Phone: ");
        contacts.add(new Contact(name, phone));
    }

    void search() {
        String key = read("Search name: ");
        contacts.stream()
                .filter(c -> c.name.toLowerCase().contains(key.toLowerCase()))
                .forEach(System.out::println);
    }

    String read(String p) {
        System.out.print(p);
        return sc.nextLine();
    }
}
