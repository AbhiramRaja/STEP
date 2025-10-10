public class PaymentGateway {
    public static void main(String[] args) {
        Payment[] payments = new Payment[] { new CreditCardPayment(), new WalletPayment() };
        for (Payment p : payments) {
            System.out.println("Payment type: " + p.getClass().getSimpleName());
            p.pay();
        }
    }
}