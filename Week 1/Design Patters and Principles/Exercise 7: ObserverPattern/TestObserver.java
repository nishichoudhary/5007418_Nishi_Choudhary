package ObserverPatternExample;

public class TestObserver
{
    public static void main(String[] args)
    {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp1 = new MobileApp("MobileApp1");
        Observer mobileApp2 = new MobileApp("MobileApp2");

        stockMarket.registerObserver(mobileApp1);
        stockMarket.registerObserver(mobileApp2);

        stockMarket.setPrice(100.0);
        stockMarket.setPrice(500.0);

        stockMarket.deregisterObserver(mobileApp2);

        stockMarket.setPrice(1000.0);
    }
}
