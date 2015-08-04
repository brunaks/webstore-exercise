package webstore.usecases;

import java.util.ArrayList;

/**
 * Created by I848075 on 03/08/2015.
 */
public class FakeUserRepository implements UserRepository
{

    private ArrayList<User> users = new ArrayList<User>();

    @Override
    public User getUserById(String userId)
    {
        throw new UserRepository.UserDoesNotExist();
    }

    @Override
    public void saveUser(User user)
    {
        this.users.add(user);
    }

    @Override
    public User getUserByEmail(String email)
    {
        for (int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getEmail().equalsIgnoreCase(email)) {
                return this.users.get(i);
            }
        }
        throw new UserRepository.UserDoesNotExist();
    }
}
