package webstore.usecases;

/**
 * Created by I848075 on 03/08/2015.
 */
public interface Repository
{
    User getUserById(String userId);
    void saveUser(User user);


    class UserDoesNotExist extends RuntimeException {

    }
}
