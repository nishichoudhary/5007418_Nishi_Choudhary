package AdapterPatternExample;

public class TestAdapter
{
    public static void main(String[] args)
    {
        Paytm paytm = new Paytm();
        PaymentProcessor paytmProcessor1 = new PaytmAdapter(paytm);
        paytmProcessor1.processPayment(100);

        PayU payu = new PayU();
        PaymentProcessor paytmProcessor2 = new PayUAdapter(payu);
        paytmProcessor2.processPayment(200);
    }
}
