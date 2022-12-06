package View;

import Model.*;
import Database.Database;
import Controller.*;

public class MainView implements View {
    public User user;
    public ToDoController todo;
    String title;
    String description;

    public MainView(Database db) {
        todo = new ToDoController(db);
    }

    public void set(User user) {
        this.user = user;
        todo.setOwner(user);
        menu();
    }

    public void menu() {
        int pilih;

        do {
            System.out.println(" ");
            System.out.println("-------------");
            System.out.println("ToDoList App");
            System.out.println("-------------");
            System.out.println("1. Display ToDo List");
            System.out.println("2. Add ToDo List");
            System.out.println("3. Edit ToDo List");
            System.out.println("4. Delete Todo List");
            System.out.println("5. Show User Data");
            System.out.println("6. Logout");

            System.out.print("Choose Menu : ");
            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {
                case 1 -> todo.show(user);

                case 2 -> {
                    this.inputData();
                    todo.store(user.id, title, description);
                    todo.show(user);
                }

                case 3 -> {
                    todo.show(user);
                    System.out.print("Select the ID you want to edit : ");
                    try {
                        pilih = input.nextInt();
                    } catch (Exception e) {
                        System.out.println("Error input!!");
                    }
                    input.nextLine();
                    this.inputData();

                    if (todo.edit(pilih, title, description)) {
                        System.out.println("ToDo edited successfully!");
                        todo.show(user);
                    } else {
                        System.out.println("No ToDo with Id " + pilih);
                    }
                }

                case 4 -> {
                    todo.show(user);
                    System.out.print("Select id you want to delete : ");
                    try {
                        pilih = input.nextInt();
                    } catch (Exception e) {
                        System.out.println("Error input!!");
                    }

                    input.nextLine();
                    if (todo.destroy(pilih)) {
                        System.out.println("ToDo deleted successfully!");
                        todo.show(user);
                    } else {
                        System.out.println("Error input!!");
                    }
                }

                case 5 -> this.showData();

                case 6 -> {
                    this.user = null;
                    System.out.println("Logout Berhasil");
                }

                default -> System.out.println("Invalid Input");
            }

        } while (pilih != 6);
    }

    public void showData() {
        System.out.println(" ");
        System.out.println("-------------");
        System.out.println("Profile User");
        System.out.println("-------------");
        System.out.println("Id : " + user.id);
        System.out.println("Name : " + user.name);
        System.out.println("Username : " + user.username);
        System.out.println("Address : " + user.address);
        System.out.println("Phone : " + user.phone);
    }

    public void inputData() {
        System.out.println(" ");
        System.out.println("-------------");
        System.out.println("ToDo List Form");
        System.out.println("-------------");
        System.out.print("Task Title : ");
        title = input.nextLine();
        System.out.print("Task Description : ");
        description = input.nextLine();
        System.out.println();
    }
}
