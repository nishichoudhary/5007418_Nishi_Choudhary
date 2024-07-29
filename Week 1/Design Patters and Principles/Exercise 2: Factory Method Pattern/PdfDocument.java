package FactoryPattern;

public class PdfDocument implements Document
{
    public void open() {
        System.out.println("Opening PDF document...");
    }

    public void close()
    {
        System.out.println("Closing PDF document...");
    }
}