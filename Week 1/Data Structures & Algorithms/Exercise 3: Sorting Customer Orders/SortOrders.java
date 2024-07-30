package Exercise_3;

public class SortOrders
{

    public static void main(String[] args)
    {
        Order[] orders = {
                new Order("1", "Nishi", 250.0),
                new Order("2", "Riya", 150.0),
                new Order("3", "Akriti", 300.0),
                new Order("4", "Kirti", 100.0)
        };

        System.out.println("Bubble Sort:");
        BubbleSort.bubbleSort(orders);
        for (Order order : orders)
        {
            System.out.println(order);
        }

        orders = new Order[]{
                new Order("1", "Nishi", 250.0),
                new Order("2", "Riya", 150.0),
                new Order("3", "Akriti", 300.0),
                new Order("4", "Kirti", 100.0)
        };

        System.out.println("\nQuick Sort:");
        QuickSort.quickSort(orders, 0, orders.length - 1);
        for (Order order : orders)
        {
            System.out.println(order);
        }
    }
}
