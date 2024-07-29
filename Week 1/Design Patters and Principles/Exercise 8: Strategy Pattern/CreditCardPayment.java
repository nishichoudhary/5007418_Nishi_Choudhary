package StrategyPatternExample;

public class CreditCardPayment implements PaymentStrategy
{
    private String cardNumber;
    private String cardHolderName;
    private String cvv;
    private String expirationDate;

    public CreditCardPayment(String cardNumber, String cardHolderName, String cvv, String expirationDate)
    {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
    }

    public void pay(double amount)
    {
        System.out.println("Paid Rs." + amount + " using Credit Card.");
    }
}
