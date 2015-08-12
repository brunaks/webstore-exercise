package webstore.usecases;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by I848075 on 03/08/2015.
 */
public class FakeUserRepositoryTest {

    public UserRepository userRepository;
    public FakeReceiver receiver;

    @Before
    public void setUp() throws Exception {
        userRepository = new FakeUserRepository();
        receiver = new FakeReceiver();
    }

    @Test(expected = UserRepository.UserDoesNotExist.class)
    public void userDoesNotExistThrowsException() {
        userRepository.getUserById("aa");
    }

    @Test
    public void userExists() {
        User user = givenUser(new Email("email@yahoo.com.br", receiver), "password");
        userRepository.save(user);
        Assert.assertTrue(userRepository.hasWithEmail("email@yahoo.com.br"));
    }

    private User givenUser(Email email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        return user;
    }

    @Test
    public void userDoesNotExist() {
        Assert.assertFalse(userRepository.hasWithEmail("email"));
    }

    @Test
    public void IdOfNewUserIsNotNull() {
        User user = givenUser(new Email("email@yahoo.com.br", receiver), "password");
        User userSaved = userRepository.save(user);

        Assert.assertNotNull(userSaved.getId());
    }

    @Test
    public void afterSavingACustomerModificationsShouldNotBeReflected() {
        User user = givenUser(new Email("email@email.com.br", receiver), "password");
        User savedUser = userRepository.save(user);

        user.setPassword("password2");
        User retrievedUser = userRepository.getUserByEmail("email@email.com.br");
        Assert.assertEquals("password", retrievedUser.getPassword());
    }
}
