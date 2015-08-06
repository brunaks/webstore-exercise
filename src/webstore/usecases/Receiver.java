package webstore.usecases;

/**
 * Created by I848075 on 04/08/2015.
 */
public interface Receiver {
    void sendErrorUserDoesNotExist();

    void sendErrorPasswordIsWrong();

    void sendSuccess();

    void sendUserWasRegisteredSuccessfully();

    void sendEmailIsInvalid();
}
