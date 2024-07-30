package Exercise_3;

public class Order
{
    private String orderId;
    private String customerName;
    private double totalPrice;

    public Order(String orderId, String customerName, double totalPrice)
    {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public String getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public double getTotalPrice() { return totalPrice; }


    public String toString()
    {
        return "Order ID: " + orderId + ", Customer: " + customerName + ", Total Price: Rs." + totalPrice;
    }
}
