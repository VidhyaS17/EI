package behavioral;

// Strategy interface
interface PaymentStrategy { void pay(int amount); }

// Concrete strategies
class CreditCardPayment implements PaymentStrategy {
    public void pay(int amount) { System.out.println("Paid " + amount + " using Credit Card"); }
}

class PayPalPayment implements PaymentStrategy {
    public void pay(int amount) { System.out.println("Paid " + amount + " using PayPal"); }
}

public class StrategyPatternDemo {
    public static void runDemo() {
        PaymentStrategy strategy = new CreditCardPayment();
        strategy.pay(100); //pay(int amount) → abstract payment method.
        strategy = new PayPalPayment();
        strategy.pay(200);
        System.out.println();
    }
}
