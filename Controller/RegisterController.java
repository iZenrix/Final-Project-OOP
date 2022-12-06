package Controller;

import Model.*;
import Database.Database;

public class RegisterController {
    int incrementId = 0;

    public User generateUser(String name, String username, String password, String phone, String address) {
        incrementId++;
        return new User(incrementId, name, username, password, phone, address);
    }

    public void storeUser(Database db, User user) {
        db.User.add(user);
    }
}
