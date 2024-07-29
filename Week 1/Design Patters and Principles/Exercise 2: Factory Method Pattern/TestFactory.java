package FactoryPattern;


public class TestFactory
{
    public static void main(String[] args)
    {
        Document factory1 = DocumentFactory.createDocument("word");
        factory1.open();
        factory1.close();

//        Document factory2 = DocumentFactory.createDocument("pdf");
//        factory2.open();
//        factory2.close();

//        Document factory3 = DocumentFactory.createDocument("excel");
//        factory3.open();
//        factory3.close();
    }
}

