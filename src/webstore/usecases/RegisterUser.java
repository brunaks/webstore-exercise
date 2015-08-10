package webstore.usecases;

/**
 * Created by I848075 on 04/08/2015.
 */
public class RegisterUser {

    private Receiver receiver;
    private UserRepository userRepository;
    private String email;
    private String password;

    public RegisterUser(UserRepository userRepository, Receiver receiver) {
        this.userRepository = userRepository;
        this.receiver = receiver;
    }

    public void setEmail(String email) {
        if (emailIsValid(email)) {
            this.email = email;
        } else {
            receiver.sendEmailIsInvalid();
        }
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void register() {
        User user = new User();
        if (this.email != null && this.password != null) {
            user.setEmail(this.email);
            user.setPassword(this.password);
            this.userRepository.save(user);
            receiver.sendUserWasRegisteredSuccessfully();
        }
    }

    private boolean emailIsValid(String email) {
        return new Email(email, receiver).isValid();
    }
}
