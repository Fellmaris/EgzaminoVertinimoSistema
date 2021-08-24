import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Student extends User {


    public Date waitingTime(Date currentTime){
        return new Date();
    };
    public boolean takeEgzamTimer(Date date){
        return true;
    };

    public Student(String name, String surname, int id, String password, Boolean isProfessor) {
        super(name, surname, id, password);
        if (isProfessor){
            System.out.println("Jūs neturite šio lygio prieigos...");
        } else {
            UserLevel user = UserLevel.STUDENT;
        }
    }

    @Override
    public String toString() {
        return "Studentas:\n" +
                "Vardas: " + getName() + "\n" +
                "Pavardė: " + getSurname() + "\n " +
                "Id: " + getId();
    }


    public boolean register(List <Student> studentai) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Sveiki studente, įveskite savo id:");
        int id = sc.nextInt();
        for (Object studentas: studentai) {
            if (getId() == id){
                System.out.println("Toks vartotojas jau yra...");
                return false;
            }
        }
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
        Student student = new Student(name, surname, id, pass, false);
        studentai.add(student);
        System.out.println("Vartotojas sėkmingai sukurtas.");
        return true;
    }
}
