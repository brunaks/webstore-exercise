package webstore.usecases;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by I848075 on 06/08/2015.
 */
public class EmailTest {

    FakeReceiver receiver;

    @Before
    public void setUp() throws Exception {
        receiver = new FakeReceiver();
    }

    @Test
    public void emailCannotBeBlank() {
        Email email = new Email("", receiver);
        email.validate();
        Assert.assertFalse(email.isValid());
        Assert.assertTrue(receiver.emailIsBlank);
        Assert.assertFalse(receiver.emailIsValid);
    }

    @Test
    public void emailMustHaveALocalPart() {
        Email email = new Email("@mail.com", receiver);
        email.validate();
        Assert.assertFalse(email.isValid());
    }

    @Test
    public void emailMustHaveADomainPart() {
        Email email = new Email("paulo@", receiver);
        email.validate();
        Assert.assertFalse(email.isValid());
    }

    @Test
    public void emailMustHaveAnAmpersat() {
        Email email = new Email("paulo.com", receiver);
        email.validate();
        Assert.assertFalse(email.isValid());
    }

    @Test
    public void emailMustHaveOnlyOneAmpersat() {
        Email email = new Email("paulo@com@", receiver);
        email.validate();
        Assert.assertFalse(email.isValid());
    }

    @Test
    public void emailIsValid() {
        Email email = new Email("email@email.com", receiver);
        email.validate();
        Assert.assertTrue(email.isValid());
    }

}
