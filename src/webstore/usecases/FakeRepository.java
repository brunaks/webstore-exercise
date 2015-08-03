package webstore.usecases;

/**
 * Created by I848075 on 03/08/2015.
 */
public class FakeRepository implements Repository {

    @Override
    public User getUserById(String userId)
    {
        throw new Repository.UserDoesNotExist();
    }

    @Override
    public void saveUser(User user)
    {

    }
}
