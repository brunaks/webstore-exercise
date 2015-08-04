package webstore.usecases;

/**
 * Created by Bruna Koch Schmitt on 03/08/2015.
 */
public class ReadCustomerInformation {

    private CustomerRepository customerRepository;
    private Customer customer;
    private String customerId;

    public ReadCustomerInformation(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void setCustomer(String customerId) {
        this.customerId = customerId;
        if (!customerIsInRepository()) {
            sendErrorThatCustomerWasNotFound();
        }

    }

    public String getName() {
        return this.customer.getName();
    }

    private void sendErrorThatCustomerWasNotFound() {
    }

    public String getId() {
        return customerId;
    }

    private boolean customerIsInRepository() {
        try {
            this.customer = customerRepository.getCustomerById(this.customerId);
            return true;
        }catch (CustomerRepository.CustomerNotFound e){
            return false;
        }
    }
}
