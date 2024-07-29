package AdapterPatternExample;

public class PayUAdapter implements PaymentProcessor
{
    private PayU payu;

    public PayUAdapter(PayU payu)
    {
        this.payu=payu;
    }

    public void processPayment(double amount)
    {
        payu.makePayment(amount);
    }
}
