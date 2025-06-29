public class TestProxy {
    public static void main(String[] args) {
        Image img1 = new ProxyImage("pic1.jpg");
        Image img2 = new ProxyImage("pic2.jpg");

        System.out.println("First call to display pic1:");
        img1.display();

        System.out.println("\nSecond call to display pic1:");
        img1.display(); 

        System.out.println("\nDisplay pic2:");
        img2.display();  
    }
}
