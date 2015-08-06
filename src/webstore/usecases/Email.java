package webstore.usecases;

/**
 * Created by I848075 on 06/08/2015.
 */
class Email {
    private String email;
    private String localPart;
    private String domainPart;

    public Email(String email) {this.email = email;}

    public boolean isValid() {
        return (this.isNotNull() && this.hasProperFormat() && this.hasALocalPart() && this.hasADomainPart());
    }

    private boolean hasADomainPart() {
        return (!this.domainPart.isEmpty());
    }

    private boolean hasALocalPart() {
        return (!this.localPart.isEmpty());
    }

    private boolean isNotNull() {
        return (this.email != null);
    }

    private boolean hasProperFormat() {
        this.email.trim();
        if (hasAmpersat()) {
            try {
                separateEmailIntoLocalAndDomainParts();
                return true;
            } catch (ArrayIndexOutOfBoundsException e) {
                return false;
            }
        }
        else {
            return false;
        }
    }

    private void separateEmailIntoLocalAndDomainParts() {
        String separatedEmail[] = this.email.split("@");
        this.localPart = separatedEmail[0];
        this.domainPart = separatedEmail[1];
    }

    private boolean hasAmpersat() {
        if (this.email.indexOf('@') > -1) {
            return true;
        }
        else {
            return false;
        }
    }
}
