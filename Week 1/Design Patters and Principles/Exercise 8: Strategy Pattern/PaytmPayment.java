package StrategyPatternExample;

public class PaytmPayment implements PaymentStrategy
{
    private String email;
    private String password;

    public PaytmPayment(String email, String password)
    {
        this.email = email;
        this.password = password;
    }

    public void pay(double amount)
    {
        System.out.println("Paid Rs." + amount + " using Paytm");
    }
}
