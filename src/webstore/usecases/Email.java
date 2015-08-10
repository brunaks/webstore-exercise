package webstore.usecases;

/**
 * Created by I848075 on 06/08/2015.
 */
class Email {
    private Receiver receiver;
    private String email;
    private String localPart;
    private String domainPart;
    private boolean isValid;

    public Email(String email, Receiver receiver) {
        this.receiver = receiver;
        if (email != null) {
            this.email = email;
        } else {
            this.receiver.sendEmailIsInvalid();
            this.receiver.sendErrorEmailCannotBeNull();
        }
    }

    public void validate() {
        if (this.isNotBlank() && this.hasAmpersat()) {
            separateEmail();
            if (this.hasLocalPart() && this.hasDomainPart() && this.hasOnlyOneAmpersat()) {
                this.receiver.sendSuccessEmailIsValid();
                this.isValid = true;
            } else {
                this.isValid = false;
            }
        }
    }

    private boolean isNotBlank() {
        if (!this.email.isEmpty()) {
            this.receiver.sendSuccessEmailIsNotBlank();
            return true;
        } else {
            this.receiver.sendErrorEmailCannotBeBlank();
            return false;
        }
    }

    private boolean hasAmpersat() {
        if (this.email.indexOf('@') != -1) {
            this.receiver.sendSuccessEmailHasAnAtSymbol();
            return true;
        } else {
            this.receiver.sendErrorEmailMustHaveAnAtSymbol();
            return false;
        }
    }

    private boolean hasOnlyOneAmpersat() {
        if (this.domainPart.indexOf('@') == -1) {
            this.receiver.sendSuccessEmailHasOnlyOneAmpersat();
            return true;
        } else {
            this.receiver.sendErrorEmailMustHaveOnlyOneAmpersat();
            return false;
        }
    }

    private boolean hasDomainPart() {
        if (!this.domainPart.isEmpty()) {
            this.receiver.sendSuccessEmailHasADomainPart();
            return true;
        } else {
            this.receiver.sendErrorEmailMustHaveADomainPart();
            return false;
        }
    }

    private boolean hasLocalPart() {
        if (!this.localPart.isEmpty()) {
            this.receiver.sendSuccessEmailHasALocalPart();
            return true;
        } else {
            this.receiver.sendErrorEmailMustHaveALocalPart();
            return false;
        }
    }

    private void separateEmail() {
        String separatedEmail[] = this.email.split("@", 2);
        this.localPart = separatedEmail[0];
        this.domainPart = separatedEmail[1];
    }

    public boolean isValid() {
        return isValid;
    }
}
