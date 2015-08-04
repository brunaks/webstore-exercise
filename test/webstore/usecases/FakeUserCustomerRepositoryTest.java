package webstore.usecases;

import org.junit.Assert;
import org.junit.Test;
import webstore.usecases.FakeUserRepository;
import webstore.usecases.User;
import webstore.usecases.UserRepository;

/**
 * Created by I848075 on 03/08/2015.
 */
public class FakeUserCustomerRepositoryTest
{
    public UserRepository userRepository = new FakeUserRepository();

    @Test (expected = UserRepository.UserDoesNotExist.class)
    public void userDoesNotExist() {
        userRepository.getUserById("aa");
    }

    @Test
    public void userExists() {
        User user = new User();
        user.setEmail("email@yahoo.com.br");
        user.setPassword("password");
        userRepository.saveUser(user);

        User userStored = userRepository.getUserById(user.getId());
        Assert.assertEquals(user.getId(), userStored.getId());
        Assert.assertEquals(user.getEmail(),userStored.getEmail());
        Assert.assertEquals(user.getPassword(),userStored.getPassword());
    }

}
