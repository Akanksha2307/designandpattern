public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        Product p1 = new Product(101, "Laptop", 10, 75000);
        Product p2 = new Product(102, "Smartphone", 25, 25000);

        manager.addProduct(p1);
        manager.addProduct(p2);
        manager.displayInventory();

        manager.updateProduct(101, 12, 73000);
        manager.deleteProduct(102);
        manager.displayInventory();
    }
}
