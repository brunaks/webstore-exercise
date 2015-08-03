package webstore.usecases;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by I848075 on 03/08/2015.
 */
public class FakeRepositoryTest
{
    public Repository repository = new FakeRepository();

    @Test (expected = Repository.UserDoesNotExist.class)
    public void userDoesNotExist() {
        repository.getUserById("aa");
    }

    @Test
    public void userExists() {
        User user = new User();
        user.setEmail("email@yahoo.com.br");
        user.setPassword("password");
        repository.saveUser(user);

        User userStored = repository.getUserById(user.getId());
        Assert.assertEquals(user.getId(), userStored.getId());
        Assert.assertEquals(user.getEmail(),userStored.getEmail());
        Assert.assertEquals(user.getPassword(),userStored.getPassword());
    }

}
