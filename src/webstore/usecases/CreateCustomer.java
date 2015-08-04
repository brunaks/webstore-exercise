package webstore.usecases;

/**
 * Created by Bruna Koch Schmitt on 02/08/2015.
 */
public class CreateCustomer {


    private CustomerRepository customerRepository;
    private String name;
    private Customer customer;
    private String customerId;

    public CreateCustomer(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void setId(String customerId) {
        this.customerId = customerId;
        this.customer = new Customer();
        customer.setId(customerId);
        customerRepository.saveCustomer(customer);
    }

    public void setName(String name) {
        this.name = name;
        Customer customer = customerRepository.getCustomerById(this.customerId);
        customer.setName(name);
        customerRepository.saveCustomer(customer);
    }

    public void setCustomer(String customerId) {
        this.customerId = customerId;
    }
}
