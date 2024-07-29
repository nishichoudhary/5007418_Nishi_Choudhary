package SingletonPattern;
public class Test
{
    public static void main(String[] args)
    {
        Logger logger1 = Logger.getInstance();
        System.out.println(logger1.hashCode());

        Logger logger2 = Logger.getInstance();
        System.out.println(logger2.hashCode());

    }
}
