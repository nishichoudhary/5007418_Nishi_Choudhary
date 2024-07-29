package ObserverPatternExample;

public class MobileApp implements Observer
{
    private String appName;

    public MobileApp(String appName)
    {
        this.appName = appName;
    }

    public void update(double price)
    {
        System.out.println(appName + " received price update: Rs." + price);
    }
}
