import java.util.HashMap;
import java.util.Map;

public class InventoryManagementSystem
{

    public static class Product
    {
        private String productId;
        private String productName;
        private int quantity;
        private double price;

        public Product(String productId, String productName, int quantity, double price)
        {
            this.productId = productId;
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
        }

        public String getProductId()
        {
            return productId;
        }
        public void setProductId(String productId)
        {
            this.productId = productId;
        }

        public String getProductName()
        {
            return productName;
        }
        public void setProductName(String productName)
        {
            this.productName = productName;
        }

        public int getQuantity()
        {
            return quantity;
        }
        public void setQuantity(int quantity)
        {
            this.quantity = quantity;
        }

        public double getPrice()
        {
            return price;
        }
        public void setPrice(double price)
        {
            this.price = price;
        }
    }

    public static class Inventory
    {
        private Map<String, Product> products;

        public Inventory()
        {
            this.products = new HashMap<>();
        }

        public void addProduct(Product product)
        {
            products.put(product.getProductId(), product);
        }

        public void updateProduct(Product product)
        {
            if (products.containsKey(product.getProductId()))
            {
                products.put(product.getProductId(), product);
            }
            else
            {
                System.out.println("Product not found.");
            }
        }

        public void deleteProduct(String productId)
        {
            if (products.containsKey(productId))
            {
                products.remove(productId);
            }
            else
            {
                System.out.println("Product not found.");
            }
        }

        public Product getProduct(String productId)
        {
            return products.get(productId);
        }
    }

    public static void main(String[] args)
    {
        Inventory inventory = new Inventory();

        Product p1 = new Product("001", "Laptop", 10, 999.99);
        Product p2 = new Product("002", "Smartphone", 20, 499.99);

        inventory.addProduct(p1);
        inventory.addProduct(p2);

        inventory.updateProduct(new Product("001", "Laptop", 8, 999.99));

        Product product = inventory.getProduct("001");
        if (product != null)
        {
            System.out.println("Product Retrieved: " + product.getProductName());
        }

        inventory.deleteProduct("002");
    }
}
