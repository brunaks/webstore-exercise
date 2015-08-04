package webstore.usecases;

import org.junit.Before;
import org.junit.Test;
import webstore.usecases.FakeReceiver;
import webstore.usecases.FakeUserRepository;
import webstore.usecases.RegisterUser;
import webstore.usecases.UserRepository;

/**
 * Created by I848075 on 04/08/2015.
 */
public class RegisterUserTest
{
    RegisterUser registerUser;
    UserRepository userRepository;
    FakeReceiver receiver;

    @Before
    public void setUp() throws Exception{
        receiver = new FakeReceiver();
        userRepository = new FakeUserRepository();
        registerUser = new RegisterUser(userRepository, receiver);
    }

    @Test
    public void registerUserSuccessfully() {
        registerUser.setEmail("email@email.com.br");
        registerUser.setPassword("123456");
        registerUser.register();
    }

}
