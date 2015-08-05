package webstore.usecases;

/**
 * Created by Bruna Koch Schmitt on 02/08/2015.
 */
public class ReadCustomersCart {

    private CustomerRepository customerRepository;
    private String customerId;
    private Customer customer;

    public ReadCustomersCart(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void setCustomer(String customerId) {
        this.customerId = customerId;
        if (!customerIsInRepository()) {
            sendErrorThatCustomerWasNotFound();
        }
    }

    private void sendErrorThatCustomerWasNotFound() {

    }

    public double getTotalPrice() {
        return customer.getCart().getTotalPrice();
    }

    private boolean customerIsInRepository() {
        try {
            this.customer = customerRepository.getCustomerById(this.customerId);
            return true;
        } catch (CustomerRepository.CustomerNotFound e) {
            return false;
        }
    }
}
