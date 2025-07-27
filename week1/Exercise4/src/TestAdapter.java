public class TestAdapter {
    public static void main(String[] args) {
        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPalGateway());
        PaymentProcessor stripeProcessor = new StripeAdapter(new StripeGateway());

        paypalProcessor.processPayment(100.0); 
        stripeProcessor.processPayment(8000.0);  
    }
}
