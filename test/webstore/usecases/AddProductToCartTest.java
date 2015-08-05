package webstore.usecases;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Bruna Koch Schmitt on 26/07/2015.
 */
public class AddProductToCartTest {

    private FakeRepository repository = new FakeRepository();
    AddProductToCart addToCart;
    ReadCustomersCart readCart;

    @Before
    public void setUp() throws Exception {
        addToCart = new AddProductToCart(this.repository, this.repository);
        readCart = new ReadCustomersCart(this.repository);
    }

    private void givenCustomer(String customerId) {
        Customer customer = new Customer();
        customer.setId(customerId);
        repository.saveCustomer(customer);
    }

    private void givenProduct(int units, double price, String productId) {
        Product product = new Product();
        product.addUnits(units);
        product.setPrice(price);
        product.setId(productId);
        repository.saveProduct(product);
    }

    @Test
    public void addOneProductAndGetPrice_SameCustomer() {
        givenProduct(30, 10.0, "product0001");
        addToCart("customer0001", "product0001", 10);
        assertCartPrice("customer0001", 100.0);
    }

    private void assertCartPrice(String customerId, double totalPrice) {
        readCart.setCustomer(customerId);
        Assert.assertEquals(totalPrice, readCart.getTotalPrice(), 0.001);
    }

    private void addToCart(String customerId, String productId, int quantity) {
        givenCustomer("customer0001");
        givenCustomer("customer0002");
        givenProduct(30, 10.00, "product0001");
        givenProduct(20, 20.00, "product0002");
        addToCart.setCustomer(customerId);
        addToCart.setProductAndQuantity(productId, quantity);
        addToCart.execute();
    }

    @Test
    public void addTwoProductsAndGetPrice_SameCustomer() {
        givenCustomer("customer0001");
        givenCustomer("customer0002");
        givenProduct(30, 10.00, "product0001");
        givenProduct(20, 20.00, "product0002");
        addToCart("customer0001", "product0001", 10);

        AddProductToCart addToCart2;
        addToCart2 = new AddProductToCart(this.repository, this.repository);
        addToCart2.setCustomer("customer0001");
        addToCart2.setProductAndQuantity("product0002", 15);
        addToCart2.execute();

        assertCartPrice("customer0001", 400.00);
    }

    @Test
    public void addAProduct_TwoCustomers() {
        givenCustomer("customer0001");
        givenCustomer("customer0002");
        givenProduct(30, 10.00, "product0001");
        givenProduct(20, 20.00, "product0002");
        addToCart("customer0001", "product0001", 10);

        AddProductToCart addToCart2;
        addToCart2 = new AddProductToCart(this.repository, this.repository);
        addToCart2.setCustomer("customer0002");
        addToCart2.setProductAndQuantity("product0001", 20);
        addToCart2.execute();

        assertCartPrice("customer0001", 100.0);
        assertCartPrice("customer0002", 200.0);
    }

    @Test
    public void addProduct_NotEnoughInStock() {
        givenCustomer("customer0001");
        givenCustomer("customer0002");
        givenProduct(30, 10.00, "product0001");
        givenProduct(20, 20.00, "product0002");
        addToCart("customer0001", "product0001", 10);
    }

}