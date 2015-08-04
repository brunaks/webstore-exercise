package webstore.usecases;

/**
 * Created by I848075 on 03/08/2015.
 */
public interface UserRepository
{
    User getUserById(String userId);
    void saveUser(User user);
    User getUserByEmail(String email);
    class UserDoesNotExist extends RuntimeException {

    }
}
