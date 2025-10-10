public class PaymentDemo {
    interface Discount {
        double apply(double amount);
    }

    public void processTransaction(double amount) {
        class Validator {
            boolean isValid(double amt) {
                return amt > 0;
            }
        }

        Validator v = new Validator();
        if (!v.isValid(amount)) {
            System.out.println("Invalid amount: " + amount);
            return;
        }

        // anonymous inner class for Discount
        Discount discount = new Discount() {
            @Override
            public double apply(double amt) {
                if (amt > 100) return amt * 0.9; // 10% off
                return amt;
            }
        };

        double finalAmount = discount.apply(amount);
        System.out.println("Original amount: " + amount + ", after discount: " + finalAmount);
    }

    public static void main(String[] args) {
        PaymentDemo p = new PaymentDemo();
        p.processTransaction(120);
        p.processTransaction(-5);
    }
}