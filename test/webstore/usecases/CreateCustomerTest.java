package webstore.usecases;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Bruna Koch Schmitt on 02/08/2015.
 */
public class CreateCustomerTest {

    private CustomerRepository customerRepository;

    @Before
    public void setUp() throws Exception {
        this.customerRepository = new FakeRepository();
    }

    @Test
    public void createACustomerSuccessfully() {
        CreateCustomer createCustomer = new CreateCustomer(customerRepository);
        createCustomer.setId("customer0001");
        createCustomer.setCustomer("customer0001");
        createCustomer.setName("Bruna");

        ReadCustomerInformation readInfo = new ReadCustomerInformation(customerRepository);
        readInfo.setCustomer("customer0001");
        Assert.assertEquals("customer0001", readInfo.getId());
        Assert.assertEquals("Bruna", readInfo.getName());
    }


}
