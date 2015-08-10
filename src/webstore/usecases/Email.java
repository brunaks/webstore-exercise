package webstore.usecases;

/**
 * Created by I848075 on 06/08/2015.
 */
class Email {
    private Receiver receiver;
    private String email;
    private String localPart;
    private String domainPart;

    public Email(String email, Receiver receiver) {
        this.receiver = receiver;
        if (email != null) {
            this.email = email;
        } else {
            this.receiver.sendErrorEmailCannotBeNull();
        }
    }

    public boolean isValid() {
        if (this.hasAmpersat()) {
            separateEmail();
            if (this.hasLocalPart() && this.hasDomainPart() && this.hasOnlyOneAmpersat()) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    private boolean hasAmpersat() {
        return (this.email.indexOf('@') != -1);
    }

    private boolean hasOnlyOneAmpersat() {
        return (this.domainPart.indexOf('@') == -1);
    }

    private boolean hasDomainPart() {
        return (!this.domainPart.isEmpty());
    }

    private boolean hasLocalPart() {
        return (!this.localPart.isEmpty());
    }

    private void separateEmail() {
        String separatedEmail[] = this.email.split("@", 2);
        this.localPart = separatedEmail[0];
        this.domainPart = separatedEmail[1];
    }
}
