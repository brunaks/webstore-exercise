package webstore.usecases;

/**
 * Created by I848075 on 04/08/2015.
 */
public class RegisterUser
{

    private UserRepository userRepository;
    private String email;
    private String password;

    public RegisterUser(UserRepository userRepository, Receiver receiver) {
        this.userRepository = userRepository;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void register()
    {
        User user = new User();

        user.setEmail(this.email);
        user.setPassword(this.password);
        this.userRepository.saveUser(user);
    }

}
