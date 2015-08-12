package webstore.usecases;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import webstore.usecases.*;

/**
 * Created by I848075 on 03/08/2015.
 */
public class LoginUseCaseTest {

    private LoginUseCase uc;
    private UserRepository userRepository;
    private RegisterUser registerUser;
    private Receiver receiver;

    @Before
    public void setUp() throws Exception {
        userRepository = new FakeUserRepository();
        receiver = new FakeReceiver();
        uc = new LoginUseCase(userRepository, receiver);
    }

    @Test
    public void loginSuccessful() {
        registerUser = new RegisterUser(this.userRepository, this.receiver);
        registerUser.setEmail(new Email("email@yahoo.com.br", receiver));
        registerUser.setPassword("password");
        registerUser.register();

        String email = "email@yahoo.com.br";
        uc.setEmail(email);
        uc.setPassword("password");
        uc.login();
        Assert.assertTrue(((FakeReceiver) receiver).successful);
    }


    @Test
    public void loginNotSuccessful_userNotRegistered() {
        String email = "email@yahoo.com.br";
        uc.setEmail(email);
        uc.setPassword(" password");
        uc.login();
        Assert.assertFalse(((FakeReceiver) receiver).successful);
        Assert.assertTrue(((FakeReceiver) receiver).userDoesNotExist);
    }

    @Test
    public void loginNotSuccessful_passwordWrong() {
        registerUser = new RegisterUser(this.userRepository, this.receiver);
        registerUser.setEmail(new Email("email@yahoo.com.br", receiver));
        registerUser.setPassword("password");
        registerUser.register();

        String email = "email@yahoo.com.br";
        uc.setEmail(email);
        uc.setPassword("Password");
        uc.login();

        Assert.assertFalse(((FakeReceiver) receiver).successful);
        Assert.assertTrue(((FakeReceiver) receiver).passwordIsWrong);
    }

}
