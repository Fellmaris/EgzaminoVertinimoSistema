import java.io.Serializable;

enum UserLevel {
    STUDENT(1), PROFESSOR(2);

    private final int id;

    public int getId() {
        return id;
    }

    UserLevel(int id) {
        this.id = id;
    }
}

public class User implements Serializable {


    private String name;
    private String surname;
    private String password;
    private int id;

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }


    public User(String name, String surname, int id, String password) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.password = password;
    }

    public User() {
    }

}
