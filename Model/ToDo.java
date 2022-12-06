package Model;

public class ToDo {
    public int id;
    public int owner;
    public String title;
    public String description;

    public ToDo(int id, int owner, String title, String description) {
        this.id = id;
        this.owner = owner;
        this.title = title;
        this.description = description;
    }
}
