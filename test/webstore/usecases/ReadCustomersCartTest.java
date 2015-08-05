package webstore.usecases;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Bruna Koch Schmitt on 02/08/2015.
 */
public class ReadCustomersCartTest {

    ReadCustomersCart readCart;
    CustomerRepository customerRepository;

    @Before
    public void setUp() throws Exception {
        readCart = new ReadCustomersCart(customerRepository);
        customerRepository = new FakeRepository();
    }

    /*@Test
    public void readCartOfCustomerThatDoesNotExist() {
        readCart.getTotalPrice();
        // Testar se o m�todo de erro foi chamado
    }*/
}
