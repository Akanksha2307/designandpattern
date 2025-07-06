public class EmployeeManager {
    private Employee[] employees;
    private int count;

    public EmployeeManager(int size) {
        employees = new Employee[size];
        count = 0;
    }
    public void addEmployee(Employee emp) {
        if (count < employees.length) {
            employees[count++] = emp;
            System.out.println(" Employee added.");
        } else {
            System.out.println("Employee array full.");
        }
    }
    public Employee searchEmployee(int empId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == empId) {
                return employees[i];
            }
        }
        return null;
    }
    public void listEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }
    public void deleteEmployee(int empId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == empId) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null; 
                System.out.println(" Employee deleted.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }
}
