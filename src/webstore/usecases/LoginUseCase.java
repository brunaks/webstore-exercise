package webstore.usecases;

/**
 * Created by I848075 on 03/08/2015.
 */
public class LoginUseCase
{
    private String email;
    private String password;

    public LoginUseCase(Repository repository)
    {

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

    }

    public boolean wasSuccessful()
    {
        return true;
    }
}
