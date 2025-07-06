public class Main {
    public static void main(String[] args) {
        Order[] orders = {
            new Order(201, "Alice", 5500),
            new Order(202, "Bob", 2500),
            new Order(203, "Charlie", 8000),
            new Order(204, "Diana", 6500)
        };
        Sorter.bubbleSort(orders);
        System.out.println(" Sorted by Bubble Sort (Descending):");
        for (Order o : orders) System.out.println(o);
        Order[] newOrders = {
            new Order(201, "Alice", 5500),
            new Order(202, "Bob", 2500),
            new Order(203, "Charlie", 8000),
            new Order(204, "Diana", 6500)
        };
        Sorter.quickSort(newOrders, 0, newOrders.length - 1);
        System.out.println("\n Sorted by Quick Sort (Descending):");
        for (Order o : newOrders) System.out.println(o);
    }
}
