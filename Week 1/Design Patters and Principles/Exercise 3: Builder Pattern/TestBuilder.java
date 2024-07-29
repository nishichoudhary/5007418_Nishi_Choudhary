package BuilderPatternExample;

public class TestBuilder
{
    public static void main(String[] args)
    {
        Computer computer = new Computer.Builder("Intel i5", 8, 256).build();
        System.out.println(computer);
    }
}
