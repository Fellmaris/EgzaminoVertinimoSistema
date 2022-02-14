import java.util.List;
import java.util.Scanner;

public class Student extends User {
    public Student(String name, String surname, int id, String password, Boolean isProfessor) {
        super(name, surname, id, password);
        if (isProfessor){
            System.out.println("Jūs neturite šio lygio prieigos...");
        } else {
            UserLevel user = UserLevel.STUDENT;
        }
    }

    public Student() {
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
        for (Student studentas: studentai) {
            if (studentas.getId() == id){
                System.out.println("Toks vartotojas jau yra...");
                return false;
            }
        }
        Student studentTemp = (Student) enterData(sc, id, false);
        Student student = new Student(studentTemp.getName(), studentTemp.getSurname(), id, studentTemp.getPassword(), false);
        studentai.add(student);
        System.out.println("Vartotojas sėkmingai sukurtas.");
        return true;
    }
}
