package View;

import Controller.*;

public class LoginView implements View {
    public LoginController loginController;
    public DbController dbController;
    public RegisterView registerView;
    public MainView mainView;

    public LoginView() {
        dbController = new DbController();
        loginController = new LoginController();
        registerView = new RegisterView(dbController.db);
        mainView = new MainView(dbController.db);
    }

    public void alreadyRegistered() {
        char answer;

        do {
            System.out.println(" ");
            System.out.println("-------------");
            System.out.println("Login System");
            System.out.println("-------------");
            System.out.print("Already Haven an Account? (y/n)");
            answer = input.next().charAt(0);
            input.nextLine();

            // switch (answer) {
            // case 'y' -> this.inputData();
            // case 'n' -> {
            // new RegisterView(dbController);
            // this.inputData();
            // }
            // default -> System.out.println("Invalid input");
            // }

            if (answer == 'y') {
                this.inputData();
            } else if (answer == 'n') {
                registerView.inputData();
                this.inputData();
            } else {
                System.out.println("Invalid input");
            }

            System.out.println(" ");
            System.out.print("Want to re-login? (y/n) ");
            answer = input.next().charAt(0);
            input.nextLine();
        } while (answer == 'y');

        System.out.println(" ");
        System.out.println("Thank You :)");
    }

    public void inputData() {
        boolean authCheck;
        String username;
        String password;

        System.out.println(" ");
        System.out.println("-------------");
        System.out.println("Login Form");
        System.out.println("-------------");

        System.out.print("Username: ");
        username = input.nextLine();
        System.out.print("Password: ");
        password = input.nextLine();

        authCheck = this.loginController.Authentication(dbController.db, username, password);
        if (authCheck) {
            mainView.set(loginController.user);
            loginController.user = null;
        } else
            System.out.println("Data not match in our record!");
    }
}
