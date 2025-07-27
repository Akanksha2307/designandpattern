public class TestObserver {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        Observer mobileUser = new MobileApp("Alice");
        Observer webUser = new WebApp("Bob");

        market.registerObserver(mobileUser);
        market.registerObserver(webUser);

        System.out.println("Updating stock price to $125.50");
        market.setPrice(125.50);

        System.out.println("\nRemoving Bob from updates.");
        market.removeObserver(webUser);

        System.out.println("Updating stock price to $130.75");
        market.setPrice(130.75);
    }
}
