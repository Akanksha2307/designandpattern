public class Main {
    public static void main(String[] args) {
        Book[] books = {
            new Book(101, "The Hobbit", "J.R.R. Tolkien"),
            new Book(102, "Harry Potter", "J.K. Rowling"),
            new Book(103, "1984", "George Orwell"),
            new Book(104, "To Kill a Mockingbird", "Harper Lee")
        };
        System.out.println("Linear Search for '1984':");
        Book result1 = LibrarySearch.linearSearch(books, "1984");
        System.out.println(result1 != null ? result1 : "Not Found");
        System.out.println("\nBinary Search for 'The Hobbit':");
        Book result2 = LibrarySearch.binarySearch(books, "The Hobbit");
        System.out.println(result2 != null ? result2 : "Not Found");
    }
}
