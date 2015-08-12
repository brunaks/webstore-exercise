package webstore.usecases;

/**
 * Created by I848075 on 04/08/2015.
 */
public class FakeReceiver implements Receiver {
    public boolean userDoesNotExist;
    public boolean passwordIsWrong;
    public boolean successful;
    public boolean userWasRegisteredSuccessfully;
    public boolean emailIsValid;
    public boolean emailIsNull;
    public boolean emailHasAnAtSymbol;
    public boolean emailHasOnlyOneAmpersat;
    public boolean emailHasADomainPart;
    public boolean emailHasALocalPart;
    public boolean emailIsBlank;
    public boolean passwordIsValid;

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
    }

    @Override
    public void sendEmailIsInvalid() {
        this.emailIsValid = false;
    }

    @Override
    public void sendErrorEmailCannotBeNull() {
        this.emailIsNull = true;
    }

    @Override
    public void sendErrorEmailMustHaveAnAtSymbol() {
        this.emailHasAnAtSymbol = false;
    }

    @Override
    public void sendErrorEmailMustHaveOnlyOneAmpersat() {
        this.emailHasOnlyOneAmpersat = false;
    }

    @Override
    public void sendErrorEmailMustHaveADomainPart() {
        this.emailHasADomainPart = false;
    }

    @Override
    public void sendErrorEmailMustHaveALocalPart() {
        this.emailHasALocalPart = false;
    }

    @Override
    public void sendSuccessEmailHasAnAtSymbol() {
        this.emailHasAnAtSymbol = true;
    }

    @Override
    public void sendSuccessEmailHasOnlyOneAmpersat() {
        this.emailHasOnlyOneAmpersat = true;
    }

    @Override
    public void sendSuccessEmailHasADomainPart() {
        this.emailHasADomainPart = true;
    }

    @Override
    public void sendSuccessEmailHasALocalPart() {
        this.emailHasALocalPart = true;
    }

    @Override
    public void sendSuccessEmailIsNotBlank() {
        this.emailIsBlank = false;
    }

    @Override
    public void sendErrorEmailCannotBeBlank() {
        this.emailIsBlank = true;
    }

    @Override
    public void sendSuccessEmailIsValid() {
        this.emailIsValid = true;
    }

    @Override
    public void sendSuccessPasswordIsValid() {
        this.passwordIsValid = true;
    }

    @Override
    public void sendErrorPasswordIsInvalid() {
        this.passwordIsValid = false;
    }
}
