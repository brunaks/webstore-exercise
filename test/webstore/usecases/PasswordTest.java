package webstore.usecases;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Bruna Koch Schmitt on 12/08/2015.
 */
public class PasswordTest {

    public Password password;
    public FakeReceiver receiver;

    @Before
    public void setUp() throws Exception{
        receiver = new FakeReceiver();
    }

    @Ignore
    @Test
    public void passwordCannotBeBlank() {
        password = new Password("", receiver);
    }
}
