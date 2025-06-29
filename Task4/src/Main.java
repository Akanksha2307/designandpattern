public class Main {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(5);

        manager.addEmployee(new Employee(101, "Alice", "Manager", 70000));
        manager.addEmployee(new Employee(102, "Bob", "Developer", 50000));
        manager.addEmployee(new Employee(103, "Clara", "Designer", 45000));

        System.out.println(" Employee List:");
        manager.listEmployees();

        System.out.println("\nSearching for ID 102:");
        System.out.println(manager.searchEmployee(102));

        System.out.println("\nDeleting ID 102...");
        manager.deleteEmployee(102);

        System.out.println("\nUpdated Employee List:");
        manager.listEmployees();
    }
}
