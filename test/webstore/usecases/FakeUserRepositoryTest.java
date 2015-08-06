package webstore.usecases;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by I848075 on 03/08/2015.
 */
public class FakeUserRepositoryTest {

    public UserRepository userRepository = new FakeUserRepository();

    @Test(expected = UserRepository.UserDoesNotExist.class)
    public void userDoesNotExistThrowsException() {
        userRepository.getUserById("aa");
    }

    @Test
    public void userExists() {
        User user = givenUser("email@yahoo.com.br", "password");
        userRepository.save(user);
        Assert.assertTrue(userRepository.hasWithEmail("email@yahoo.com.br"));
    }

    private User givenUser(String email, String password) {
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
        User user = givenUser("email@yahoo.com.br", "password");
        User userSaved = userRepository.save(user);

        Assert.assertNotNull(userSaved.getId());
    }

    @Test
    public void afterSavingACustomerModificationsShouldNotBeReflected() {
        User user = givenUser("email@email.com.br", "password");
        User savedUser = userRepository.save(user);

        user.setPassword("password2");
        User retrievedUser = userRepository.getUserByEmail("email@email.com.br");
        Assert.assertEquals("password", retrievedUser.getPassword());
    }
}
