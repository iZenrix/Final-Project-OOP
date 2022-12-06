package Model;

public class User {
    public int id;
    public String name;
    public String username;
    public String password;
    public String phone;
    public String address;

    public User(int id, String name, String username, String password, String phone, String address) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }
}