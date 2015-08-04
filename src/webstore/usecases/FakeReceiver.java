package webstore.usecases;

/**
 * Created by I848075 on 04/08/2015.
 */
public class FakeReceiver implements Receiver
{
    public boolean userDoesNotExist;
    public boolean passwordIsWrong;
    public boolean successful;

    @Override
    public void sendErrorUserDoesNotExist()
    {
        this.userDoesNotExist = true;
    }

    @Override
    public void sendErrorPasswordIsWrong()
    {
        this.passwordIsWrong = true;
    }

    @Override
    public void sendSuccess()
    {
        this.successful = true;
    }
}
