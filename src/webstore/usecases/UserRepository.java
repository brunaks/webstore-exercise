package webstore.usecases;

/**
 * Created by I848075 on 03/08/2015.
 */
public interface UserRepository {
    User getUserById(String userId);

    User save(User user);
    User getUserByEmail(String email);

    boolean hasWithEmail(String id);
    class UserDoesNotExist extends RuntimeException {

    }
}
