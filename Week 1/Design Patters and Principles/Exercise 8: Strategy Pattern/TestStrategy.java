package StrategyPatternExample;
public class TestStrategy
{
    public static void main(String[] args)
    {
        PaymentContext context = new PaymentContext();

        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9012-3456", "Nishi Choudhary", "123", "12/27");
        context.setPaymentStrategy(creditCardPayment);
        context.executePayment(1000.00);

        PaymentStrategy paytmPayment = new PaytmPayment("1234567890@paytm", "password");
        context.setPaymentStrategy(paytmPayment);
        context.executePayment(100.00);
    }
}
