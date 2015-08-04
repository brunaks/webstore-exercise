package webstore.usecases;

/**
 * Created by I848075 on 04/08/2015.
 */
public interface CustomerRepository
{
    void saveCustomer(Customer customer);

    Customer getCustomerById(String id);

    class CustomerNotFound extends RuntimeException {

    }
}
