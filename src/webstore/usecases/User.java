package webstore.usecases;

/**
 * Created by I848075 on 03/08/2015.
 */
public class User {

    private String id;
    private String email;
    private String password;

    public String getId() {
        return id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(String id) {
        this.id = id;
    }
}
