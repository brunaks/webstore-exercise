package webstore.usecases;

import java.util.ArrayList;

/**
 * Created by I848075 on 06/08/2015.
 */
public class FakeProductRepository implements ProductRepository {

    private ArrayList<Product> storedProducts = new ArrayList<Product>();

    @Override
    public void saveProduct(Product product) {
        for (int i = 0; i < storedProducts.size(); i++) {
            if (product == this.storedProducts.get(i)) {
                return;
            }
        }
        this.storedProducts.add(product);
    }

    @Override
    public Product getProductById(String productId) {
        for (int i = 0; i < storedProducts.size(); i++) {
            if (productId.equalsIgnoreCase(this.storedProducts.get(i).getId())) {
                return this.storedProducts.get(i);
            }
        }
        throw new ProductNotFound();
    }
}
