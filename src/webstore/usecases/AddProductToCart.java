package webstore.usecases;

/**
 * Created by Bruna Koch Schmitt on 24/07/2015.
 */
public class AddProductToCart {

    private ProductRepository productRepository;
    CustomerRepository customerRepository;
    private String customerId;
    private String productId;
    private int quantity;
    private boolean successful;
    private Customer customer;
    private Product product;

    public AddProductToCart(ProductRepository productRepository, CustomerRepository customerRepository)
    {
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
    }

    public boolean execute() {
        return productIsAddedToCart();
    }

    private boolean productIsAddedToCart() {
        try {
            customer.getCart().addItem(this.product, this.quantity);
            customerRepository.saveCustomer(customer);
            return this.successful = true;
        }
        catch (CartItem.NotEnoughtStockForProduct e) {
            return this.successful = false;
        }
    }

    private boolean productIsInRepository() {
        try {
            this.product = productRepository.getProductById(this.productId);
            return true;
        } catch (ProductRepository.ProductNotFound e) {
            return false;
        }
    }

    private boolean customerIsInRepository() {
        try {
            this.customer = customerRepository.getCustomerById(this.customerId);
            return true;
        }catch (CustomerRepository.CustomerNotFound e){
            return false;
        }
    }

    public void setCustomer(String customerId) {
        this.customerId = customerId;
        if (!customerIsInRepository()) {
            sendErrorThatCustomerWasNotFound();
        }
    }

    private void sendErrorThatCustomerWasNotFound() {
    }

    public void setProductAndQuantity(String productId, int quantity) {
        this.productId = productId;
        if (!productIsInRepository()) {
            sendErrorThatProductWasNotFound();
        }
        this.quantity = quantity;
    }

    private void sendErrorThatProductWasNotFound() {
    }

}
