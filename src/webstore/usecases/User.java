package webstore.usecases;

/**
 * Created by I848075 on 03/08/2015.
 */
public class User {

    private String id;
    private Email email;
    private String password;

    public String getId() {
        return id;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Email getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(String id) {
        this.id = id;
    }
}
