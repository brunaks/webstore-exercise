package webstore.usecases;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by I848075 on 03/08/2015.
 */
public class LoginUseCaseTest
{

    private LoginUseCase uc;
    private Repository repository;

    @Before
    public void setUp() throws Exception {
        repository = new FakeRepository();
        uc = new LoginUseCase(repository);
    }

    @Test
    public void loginSuccessful() {

        String email = "email@yahoo.com.br";
        uc.setEmail(email);
        uc.setPassword(" password");
        uc.login();

        Assert.assertTrue(uc.wasSuccessful());
    }


    @Test
    public void loginNotSuccessful_userNotRegistered() {
        String email = "email@yahoo.com.br";
        uc.setEmail(email);
        uc.setPassword(" password");
        uc.login();

        Assert.assertFalse(uc.wasSuccessful());
    }
}
