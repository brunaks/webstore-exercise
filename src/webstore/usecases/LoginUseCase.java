package webstore.usecases;

/**
 * Created by I848075 on 03/08/2015.
 */
public class LoginUseCase
{
    private final UserRepository userRepository;
    private final Receiver receiver;
    private String email;
    private String password;

    public LoginUseCase(UserRepository userRepository, Receiver receiver)
    {
        this.userRepository = userRepository;
        this.receiver = receiver;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void login()
    {
        try {
            User user = userRepository.getUserByEmail(this.email);
            testsIfPasswordIsValid(user);
        } catch (UserRepository.UserDoesNotExist e) {
            receiver.sendErrorUserDoesNotExist();
        }
    }

    private void testsIfPasswordIsValid(User user)
    {
        if (user.getPassword().equals(this.password)) {
            receiver.sendSuccess();
        } else {
            receiver.sendErrorPasswordIsWrong();
        }
    }
}
