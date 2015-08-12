package webstore.usecases;

import java.util.UUID;

/**
 * Created by Bruna Koch Schmitt on 11/08/2015.
 */
public class Password {

    private String password;
    private Receiver receiver;
    private boolean isValid;

    public Password (String password, Receiver receiver) {
        this.password = password;
        this.receiver = receiver;
    }

    public void validate() {
        if (isNotNull() && isNotBlank() && hasMinimumOfCharacters() && hasProperFormat()) {
            receiver.sendSuccessPasswordIsValid();
            this.isValid = true;
        } else {
            receiver.sendErrorPasswordIsInvalid();
            this.isValid = false;
        }
    }

    private boolean hasProperFormat() {
        return false;
    }

    private boolean hasMinimumOfCharacters() {
        return false;
    }

    private boolean isNotBlank() {
        return false;
    }

    private boolean isNotNull() {
        return false;
    }
}
