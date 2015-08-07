package webstore.usecases;

/**
 * Created by I848075 on 06/08/2015.
 */
class Email {
    private String email;
    private String localPart;
    private String domainPart;

    public Email(String email) {
        this.email = email;
    }

    public boolean isValid() {
        separateEmail();
        return false;
    }

    private void separateEmail() {
        String separatedEmail[] = this.email.split("@", 2);

    }
}
