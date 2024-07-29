package DependencyInjectionExample;

public class CustomerRepositoryImpl implements CustomerRepository
{
    public Customer findCustomerById(String id)
    {
        return new Customer(id, "Nishi Choudhary");
    }
}