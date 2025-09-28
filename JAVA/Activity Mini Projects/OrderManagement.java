import java.util.*;

class Order {
    final int id;
    final Map<String, Integer> items = new HashMap<>();

    Order(int id) {
        this.id = id;
    }

    void addItem(String item, int qty) {
        items.put(item, items.getOrDefault(item, 0) + qty);
    }

    double total(Map<String, Double> priceList) {
        return items.entrySet().stream()
                .mapToDouble(e -> e.getValue() * priceList.getOrDefault(e.getKey(), 0.0))
                .sum();
    }

    public String toString() {
        return "Order " + id + " " + items;
    }
}

public class OrderManagement {
    private final Map<String, Double> priceList = new HashMap<>();
    private final List<Order> orders = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new OrderManagement().run();
    }

    void run() {
        priceList.put("Burger", 120.0);
        priceList.put("Pizza", 250.0);

        int ch;
        do {
            System.out.println("\n1. Place Order");
            System.out.println("2. Show Orders");
            System.out.println("3. Exit");

            ch = Integer.parseInt(sc.nextLine());
            switch (ch) {
                case 1 -> placeOrder();
                case 2 -> orders.forEach(System.out::println);
            }
        } while (ch != 3);
    }

    void placeOrder() {
        Order o = new Order(orders.size() + 1);
        while (true) {
            String item = read("Item (done to finish): ");
            if (item.equalsIgnoreCase("done")) break;
            if (!priceList.containsKey(item)) {
                System.out.println("No price for " + item);
                continue;
            }
            int qty = Integer.parseInt(read("Qty: "));
            o.addItem(item, qty);
        }
        orders.add(o);
        System.out.println("Total: ₹" + o.total(priceList));
    }

    String read(String p) {
        System.out.print(p);
        return sc.nextLine();
    }
}
