package data;

import java.io.Serializable;
import java.util.Objects;

// Class for representing users
public abstract class User implements Serializable {
    private static final long serialVersionUID = 3187078139801519107L;

    private String login;
    private String email;
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //CONSTRUCTOR
    public User(String login, String email, String password) {
        super();
        this.login = login;
        this.email = email;
        this.password = password;
    }

    //METHODS

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, email, password);
    }

    @Override
    public String toString() {
        return "User: " + login + ", Email: " + email + ", Password: " + password;
    }
}
