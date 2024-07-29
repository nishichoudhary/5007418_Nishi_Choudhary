package DependencyInjectionExample;

public class TestDependencyInjection
{
    public static void main(String[] args)
    {
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        CustomerService customerService = new CustomerService(customerRepository);

        Customer customer = customerService.findCustomerById("354");

        System.out.println("Customer ID: " + customer.getId());
        System.out.println("Customer Name: " + customer.getName());
    }
}