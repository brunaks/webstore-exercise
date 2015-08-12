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

    void sendErrorEmailCannotBeNull();

    void sendErrorEmailMustHaveAnAtSymbol();

    void sendErrorEmailMustHaveOnlyOneAmpersat();

    void sendErrorEmailMustHaveADomainPart();

    void sendErrorEmailMustHaveALocalPart();

    void sendSuccessEmailHasAnAtSymbol();

    void sendSuccessEmailHasOnlyOneAmpersat();

    void sendSuccessEmailHasADomainPart();

    void sendSuccessEmailHasALocalPart();

    void sendSuccessEmailIsNotBlank();

    void sendErrorEmailCannotBeBlank();

    void sendSuccessEmailIsValid();

    void sendSuccessPasswordIsValid();

    void sendErrorPasswordIsInvalid();
}
