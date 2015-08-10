package webstore.usecases;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by I848075 on 06/08/2015.
 */
public class EmailTest {

    Receiver receiver;

    @Before
    public void setUp() throws Exception {
        receiver = new FakeReceiver();
    }

    @Test
    public void emailCannotBeBlank() {
        Email email = new Email("", receiver);
        Assert.assertFalse(email.isValid());
    }

    @Test
    public void emailMustHaveALocalPart() {
        Email email = new Email("@mail.com", receiver);
        Assert.assertFalse(email.isValid());
    }

    @Test
    public void emailMustHaveADomainPart() {
        Email email = new Email("paulo@", receiver);
        Assert.assertFalse(email.isValid());
    }

    @Test
    public void emailMustHaveAnAmpersat() {
        Email email = new Email("paulo.com", receiver);
        Assert.assertFalse(email.isValid());
    }

    @Test
    public void emailMustHaveOnlyOneAmpersat() {
        Email email = new Email("paulo@com@", receiver);
        Assert.assertFalse(email.isValid());
    }

    @Test
    public void emailIsValid() {
        Email email = new Email("email@email.com", receiver);
        Assert.assertTrue(email.isValid());
    }

}
