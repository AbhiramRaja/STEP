public class CreditCardPayment extends Payment {
    @Override
    public void pay() {
        System.out.println("Processing credit card payment...");
    }
}