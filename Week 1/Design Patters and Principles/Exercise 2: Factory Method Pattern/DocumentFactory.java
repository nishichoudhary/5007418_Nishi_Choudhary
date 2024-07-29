package FactoryPattern;

public class DocumentFactory
{
    public static Document createDocument(String type)
    {
        if (type.trim().equalsIgnoreCase("word"))
        {
            return new WordDocument();
        }
        else if (type.trim().equalsIgnoreCase("pdf"))
        {
            return new PdfDocument();
        }
        else if (type.trim().equalsIgnoreCase("excel")) {
            return new ExcelDocument();
        }
        else
        {
            return null;
        }
    }
}
