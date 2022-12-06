package View;

import Controller.*;
import Database.Database;

public class RegisterView implements View {
    public RegisterController registerController;
    public Database db;

    public RegisterView(Database db) {
        registerController = new RegisterController();
        this.db = db;
    }

    public void inputData() {
        String name;
        String username;
        String password;
        String phone;
        String address;

        System.out.println(" ");
        System.out.println("-------------");
        System.out.println("Register Form");
        System.out.println("-------------");

        System.out.print("Name: ");
        name = input.nextLine();
        System.out.print("Username: ");
        username = input.nextLine();
        System.out.print("Password: ");
        password = input.nextLine();
        System.out.print("Phone: ");
        phone = input.nextLine();
        System.out.print("Address: ");
        address = input.nextLine();

        registerController.storeUser(db, registerController.generateUser(name, username, password, phone, address));
    }
}
