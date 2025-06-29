public class Main {
    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shoes", "Fashion"),
            new Product(103, "Book", "Education"),
            new Product(104, "Phone", "Electronics")
        };

        Product result1 = SearchEngine.linearSearch(products, "Book");
        System.out.println(" Linear Search Result: " + (result1 != null ? result1 : "Not Found"));

        Product result2 = SearchEngine.binarySearch(products, "Phone");
        System.out.println(" Binary Search Result: " + (result2 != null ? result2 : "Not Found"));
    }
}
