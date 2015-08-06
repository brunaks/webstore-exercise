package webstore.usecases;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by I848075 on 06/08/2015.
 */
public class EmailTest {

    @Test
    public void emailCannotBeBlank() {
        Email email = new Email("");
        Assert.assertFalse(email.isValid());
    }

    @Test
    public void emailMustHaveALocalPart() {
        Email email = new Email("@mail.com");
        Assert.assertFalse(email.isValid());
    }

    @Test
    public void emailMustHaveADomainPart() {
        Email email = new Email("paulo@");
        Assert.assertFalse(email.isValid());
    }

    @Test
    public void emailMustHaveAnAmpersat() {

    }
}
