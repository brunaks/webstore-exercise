package webstore.usecases;

/**
 * Created by Bruna Koch Schmitt on 26/07/2015.
 */
public interface ProductRepository {

    void saveProduct(Product product);

    Product getProductById(String productId);

    class ProductNotFound extends RuntimeException {

    }
}
