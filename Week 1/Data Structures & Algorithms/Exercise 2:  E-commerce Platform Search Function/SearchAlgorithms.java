package Exercise_2;

import java.util.Arrays;

public class SearchAlgorithms
{
    public static Product linearSearch(Product[] products, String searchKey)
    {
        for (Product product : products)
        {
            if (product.getProductId().equals(searchKey))
            {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String searchKey)
    {
        int left = 0;
        int right = products.length - 1;

        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            if (products[mid].getProductId().equals(searchKey))
            {
                return products[mid];
            }
            else if (products[mid].getProductId().compareTo(searchKey) < 0)
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args)
    {
        Product[] products = {
                new Product("001", "Laptop", "Electronics"),
                new Product("002", "Smartphone", "Electronics"),
                new Product("003", "Tablet", "Electronics")
        };

        System.out.println("Linear Search:");
        Product result1 = linearSearch(products, "002");
        if (result1 != null) {
            System.out.println("Found: " + result1.getProductName());
        } else {
            System.out.println("Product not found.");
        }
        Arrays.sort(products, (p1, p2) -> p1.getProductId().compareTo(p2.getProductId()));

        System.out.println("\nBinary Search:");
        Product result2 = binarySearch(products, "003");
        if (result2 != null)
        {
            System.out.println("Found: " + result2.getProductName());
        }
        else
        {
            System.out.println("Product not found.");
        }
    }
}
