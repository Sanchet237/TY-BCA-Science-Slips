import java.util.*;

class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return id + " - " + name + " - ₹" + price;
    }
}

public class ShoppingCartApp {
    private final Map<Integer, Product> catalog = new HashMap<>();
    private final Map<Integer, Integer> cart = new HashMap<>();
    private final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new ShoppingCartApp().run();
    }

    void run() {
        seed();
        int ch;

        do {
            menu();
            ch = Integer.parseInt(sc.nextLine());

            switch (ch) {
                case 1 -> showCatalog();
                case 2 -> addToCart();
                case 3 -> removeFromCart();
                case 4 -> showCart();
                case 5 -> checkout();
                case 6 -> System.out.println("Exit");
            }
        } while (ch != 6);
    }

    void seed() {
        catalog.put(1, new Product(1, "T-shirt", 399));
        catalog.put(2, new Product(2, "Headphones", 1299));
        catalog.put(3, new Product(3, "Notebook", 49));
    }

    void menu() {
        System.out.println("\n1. Catalog");
        System.out.println("2. Add to Cart");
        System.out.println("3. Remove from Cart");
        System.out.println("4. Show Cart");
        System.out.println("5. Checkout");
        System.out.println("6. Exit");
        System.out.print("Choice: ");
    }

    void showCatalog() {
        catalog.values().forEach(System.out::println);
    }

    void addToCart() {
        int pid = readInt("Product ID: ");
        if (!catalog.containsKey(pid)) {
            System.out.println("No such product.");
            return;
        }

        int qty = readInt("Qty: ");
        cart.put(pid, cart.getOrDefault(pid, 0) + qty);

        System.out.println("Added.");
    }

    void removeFromCart() {
        int pid = readInt("Product ID to remove: ");
        if (!cart.containsKey(pid)) {
            System.out.println("Not in cart.");
            return;
        }

        cart.remove(pid);
        System.out.println("Removed.");
    }

    void showCart() {
        System.out.println("Cart:");
        double total = 0;

        for (var e : cart.entrySet()) {
            Product p = catalog.get(e.getKey());
            int q = e.getValue();
            double sub = p.price * q;
            total += sub;

            System.out.println(p.name + " x" + q + " = ₹" + sub);
        }

        System.out.println("Total: ₹" + total);
    }

    void checkout() {
        showCart();
        System.out.println("Proceed to checkout? (y/n)");

        String r = sc.nextLine();
        if (r.equalsIgnoreCase("y")) {
            cart.clear();
            System.out.println("Order placed.");
        } else {
            System.out.println("Cancelled.");
        }
    }

    int readInt(String p) {
        System.out.print(p);
        return Integer.parseInt(sc.nextLine());
    }
}
