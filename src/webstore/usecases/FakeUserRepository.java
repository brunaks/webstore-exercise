package webstore.usecases;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by I848075 on 03/08/2015.
 */
public class FakeUserRepository implements UserRepository {

    private ArrayList<User> users = new ArrayList<User>();

    @Override
    public User getUserById(String userId) {
        throw new UserRepository.UserDoesNotExist();
    }

    @Override
    public User save(User user) {
        User savedUser = new User();
        savedUser.setEmail(user.getEmail());
        savedUser.setPassword(user.getPassword());
        savedUser.setId(this.generateUUID());
        this.users.add(savedUser);
        return savedUser;
    }

    @Override
    public User getUserByEmail(String email) {
        User match = findUserWithEmail(email);

        if (match != null)
            return match;
        else
            throw new UserRepository.UserDoesNotExist();
    }

    @Override
    public boolean hasWithEmail(String email) {
        return findUserWithEmail(email) != null;
    }

    private User findUserWithEmail(String email) {
        User match = null;
        for (int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getEmail().toString().equalsIgnoreCase(email)) {
                match = this.users.get(i);
            }
        }
        return match;
    }

    private String generateUUID() {
        String id = UUID.randomUUID().toString();
        return id;
    }
}
