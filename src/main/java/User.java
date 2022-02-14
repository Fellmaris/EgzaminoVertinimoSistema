import java.io.Serializable;
import java.util.Scanner;

enum UserLevel {
    STUDENT(1), PROFESSOR(2);

    private final int userLevel;

    public int getId() {
        return userLevel;
    }

    UserLevel(int userLevel) {
        this.userLevel = userLevel;
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

    public Object enterData(Scanner sc, int id, boolean isProfessor){
        System.out.println("Iveskite savo vardą:");
        String name = sc.next();
        System.out.println("Įveskite savo pavardę:");
        String surname = sc.next();
        String pass;
        while (true) {
            System.out.println("Įveskite norimą slaptažodį:");
            String pass1 = sc.next();
            System.out.println("Pakartokite savo slaptažodį:");
            String pass2 = sc.next();
            if (!pass1.equals(pass2)) {
                System.out.println("Slaptažodžiai nesutapo, bandykite dar kartą...");
            } else {
                pass = pass1;
                break;
            }
        }
        if(isProfessor){
            return new Destytojas(name, surname, id, pass, true);
        } else {
            return new Student(name, surname, id, pass, false);
        }
    }
}
