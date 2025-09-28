import java.util.*;

class ProductItem {
    final int id;
    final String name;
    int qty;

    ProductItem(int id, String name, int qty) {
        this.id = id;
        this.name = name;
        this.qty = qty;
    }

    @Override
    public String toString() {
        return id + " " + name + " Qty: " + qty;
    }
}

public class InventoryManagement {
    private final Map<Integer, ProductItem> stock = new HashMap<>();
    private final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new InventoryManagement().run();
    }

    void run() {
        stock.put(1, new ProductItem(1, "Pen", 100));
        stock.put(2, new ProductItem(2, "Mouse", 25));

        int ch;
        do {
            System.out.println("\n1. Add Product");
            System.out.println("2. Update Qty");
            System.out.println("3. Show Stock");
            System.out.println("4. Exit");

            ch = Integer.parseInt(sc.nextLine());

            switch (ch) {
                case 1 -> addProduct();
                case 2 -> updateQty();
                case 3 -> stock.values().forEach(System.out::println);
            }
        } while (ch != 4);
    }

    void addProduct() {
        int id = Integer.parseInt(read("ID: "));
        String name = read("Name: ");
        int qty = Integer.parseInt(read("Qty: "));

        stock.put(id, new ProductItem(id, name, qty));
        System.out.println("Added.");
    }

    void updateQty() {
        int id = Integer.parseInt(read("ID: "));
        ProductItem it = stock.get(id);

        if (it == null) {
            System.out.println("Not found.");
            return;
        }

        int delta = Integer.parseInt(read("Change qty (+/-): "));
        it.qty += delta;

        System.out.println("Updated to " + it.qty);
    }

    String read(String p) {
        System.out.print(p);
        return sc.nextLine();
    }
}
