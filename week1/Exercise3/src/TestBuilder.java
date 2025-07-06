public class TestBuilder {
    public static void main(String[] args) {
        Computer basicComputer = new Computer.Builder("i5", "8GB").build();

        Computer gamingComputer = new Computer.Builder("i7", "16GB")
                .storage("1TB SSD")
                .graphicsCard("NVIDIA RTX 3060")
                .operatingSystem("Windows 11")
                .build();

        Computer devMachine = new Computer.Builder("M1", "16GB")
                .storage("512GB SSD")
                .operatingSystem("macOS")
                .build();

        System.out.println("Basic: " + basicComputer);
        System.out.println("Gaming: " + gamingComputer);
        System.out.println("Developer: " + devMachine);
    }
}
