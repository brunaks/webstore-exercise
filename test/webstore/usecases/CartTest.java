package webstore.usecases;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import webstore.usecases.Cart;
import webstore.usecases.Product;

import java.util.ArrayList;

/**
 * Created by I848075 on 09/07/2015.
 */
public class CartTest {
    public Cart cart;
    public Product product;

    @Before
    public void setUp() throws Exception {
        cart = new Cart();
        product = new Product();
    }

    @Test
    public void newCartIsEmpty() {
        Assert.assertTrue(cart.isEmpty());
    }

    @Test
    public void newCartHasTotalPriceOfZero() {
        Assert.assertEquals(0, cart.getTotalPrice(), 0.001);
    }


    @Test
    public void itemCanBeAddedToTheCart() {
        product.setName("Banana Caturra");
        product.addUnits(20);
        cart.addItem(product, 10);
        Assert.assertEquals("Banana Caturra", cart.getCartItems().get(0).getProduct().getName());
        Assert.assertEquals(10, cart.getCartItems().get(0).getQuantity());
        Assert.assertEquals(1, cart.getCartItems().size());

    }

    @Test
    public void itemsCanBeAddedToTheCart() {
        Product product2 = new Product();
        product.setName("Banana Caturra");
        product.addUnits(20);
        product2.setName("Banana Prata");
        product2.addUnits(20);
        cart.addItem(product, 10);
        cart.addItem(product2, 10);
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(product);
        products.add(product2);
        Assert.assertEquals(products.get(0).getName(), cart.getCartItems().get(0).getProduct().getName());
        Assert.assertEquals(products.get(1).getName(), cart.getCartItems().get(1).getProduct().getName());
        Assert.assertEquals(2, cart.getCartItems().size());
    }

    @Test
    public void cartMustReturnProductAndQuantityofProduct() {
        product.setName("Banana");
        product.setPrice(15.00);
        product.addUnits(15);
        cart.addItem(product, 10);
        Assert.assertEquals("Banana", cart.getCartItems().get(0).getProduct().getName());
        Assert.assertEquals(10, cart.getCartItems().get(0).getQuantity());
    }

    @Test
    public void cartMustReturnProductAndQuantityOfProducts() {
        product.setName("Banana");
        product.setPrice(15.00);
        product.addUnits(15);
        cart.addItem(product, 10);

        Product product2 = new Product();
        product2.setName("Ma��");
        product2.setPrice(20.00);
        product2.addUnits(20);
        cart.addItem(product2, 15);

        Assert.assertEquals("Banana", cart.getCartItems().get(0).getProduct().getName());
        Assert.assertEquals(10, cart.getCartItems().get(0).getQuantity());

        Assert.assertEquals("Ma��", cart.getCartItems().get(1).getProduct().getName());
        Assert.assertEquals(15, cart.getCartItems().get(1).getQuantity());
    }

    @Test(expected = Cart.ItemIsAlreadyInTheCart.class)
    public void cartCannotHaveTwoItensWithTheSameProduct() {
        product.setName("Banana");
        product.setPrice(15.00);
        product.addUnits(15);
        cart.addItem(product, 10);
        cart.addItem(product, 15);
    }

    @Test
    public void itemCanBeRemovedFromCart() {
        product.setName("Banana");
        product.setPrice(15.00);
        product.addUnits(15);
        cart.addItem(product, 10);
        Assert.assertEquals(1, cart.getCartItems().size());
        cart.removeProduct(product);
        Assert.assertEquals(0, cart.getCartItems().size());
    }

    @Test
    public void cartCanBeEmptied() {
        product.setName("Banana");
        product.setPrice(15.00);
        product.addUnits(15);
        cart.addItem(product, 10);

        Product product2 = new Product();
        product2.setName("Ma��");
        product2.setPrice(20.00);
        product2.addUnits(20);
        cart.addItem(product2, 15);

        Assert.assertEquals(2, cart.getNumberOfItens());
        cart.emptyCart();
        Assert.assertEquals(0, cart.getNumberOfItens());
    }

    @Test
    public void cartIsNoLongerEmptyIfItHasAnyItem() {
        product.setName("Banana");
        product.setPrice(15.00);
        product.addUnits(15);
        cart.addItem(product, 10);

        Assert.assertFalse(cart.isEmpty());
    }

    @Test
    public void cartIsEmptyIfAllProductsWereRemoved() {
        product.setName("Banana");
        product.setPrice(15.00);
        product.addUnits(15);
        cart.addItem(product, 10);

        Product product2 = new Product();
        product2.setName("Ma��");
        product2.setPrice(20.00);
        product2.addUnits(20);
        cart.addItem(product2, 15);

        Assert.assertFalse(cart.isEmpty());
        cart.emptyCart();
        Assert.assertTrue(cart.isEmpty());
    }

    @Test
    public void cartCanReturnItsTotalPrice() {
        product.setName("Banana");
        product.setPrice(15.00);
        product.addUnits(15);
        cart.addItem(product, 10);

        Product product2 = new Product();
        product2.setName("Ma��");
        product2.setPrice(20.00);
        product2.addUnits(20);
        cart.addItem(product2, 15);

        Assert.assertEquals(450.0, cart.getTotalPrice(), 0.001);
    }

}
