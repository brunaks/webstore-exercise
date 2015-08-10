package webstore.usecases;

/**
 * Created by I848075 on 04/08/2015.
 */
public class FakeReceiver implements Receiver {
    public boolean userDoesNotExist;
    public boolean passwordIsWrong;
    public boolean successful;
    public boolean userWasRegisteredSuccessfully;
    public boolean emailIsInvalid;
    private boolean emailIsNull;

    @Override
    public void sendErrorUserDoesNotExist() {
        this.userDoesNotExist = true;
    }

    @Override
    public void sendErrorPasswordIsWrong() {
        this.passwordIsWrong = true;
    }

    @Override
    public void sendSuccess() {
        this.successful = true;
    }

    @Override
    public void sendUserWasRegisteredSuccessfully() {
        this.userWasRegisteredSuccessfully = true;
        this.emailIsInvalid = false;
    }

    @Override
    public void sendEmailIsInvalid() {
        this.userWasRegisteredSuccessfully = false;
        this.emailIsInvalid = true;
    }

    @Override
    public boolean sendErrorEmailCannotBeNull() {
        return this.emailIsNull = true;
    }
}
