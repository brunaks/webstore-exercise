package webstore.usecases;

/**
 * Created by I848075 on 04/08/2015.
 */
public class RegisterUser {

    private Receiver receiver;
    private UserRepository userRepository;
    private Email email;
    private String password;

    public RegisterUser(UserRepository userRepository, Receiver receiver) {
        this.userRepository = userRepository;
        this.receiver = receiver;
    }

    public void setEmail(Email email) {
        if (emailIsValid(email.toString())) {
            this.email = new Email(email.toString(), receiver);
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
        Email emailToValidate = new Email(email, receiver);
        emailToValidate.validate();
        return emailToValidate.isValid();
    }


}
