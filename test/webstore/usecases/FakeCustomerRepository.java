package webstore.usecases;

import java.util.ArrayList;

/**
 * Created by Bruna Koch Schmitt on 02/08/2015.
 */
class FakeCustomerRepository implements CustomerRepository {

    private ArrayList<Customer> storedCustomers = new ArrayList<Customer>();

    @Override
    public Customer getCustomerById(String id) {
        for (int i = 0; i < this.storedCustomers.size(); i++) {
            if (storedCustomers.get(i).getId().equalsIgnoreCase(id)) {
                return this.storedCustomers.get(i);
            }
        }
        throw new CustomerNotFound();
    }

    @Override
    public void saveCustomer(Customer customer) {
        for (int i = 0; i < storedCustomers.size(); i++) {
            if (customer == this.storedCustomers.get(i)) {
                return;
            }
        }
        this.storedCustomers.add(customer);
    }
}
