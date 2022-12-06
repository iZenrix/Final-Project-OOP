package Controller;

import Model.*;
import Database.Database;
import java.util.Objects;

public class LoginController {
    public User user;

    public boolean Authentication(Database db, String username, String password) {
        for (User user : db.User) {
            if (Objects.equals(user.username, username) && Objects.equals(user.password, password)) {
                setAuthUser(user);
                return true;
            }
        }
        return false;
    }

    public void setAuthUser(User user) {
        this.user = user;
    }
}
