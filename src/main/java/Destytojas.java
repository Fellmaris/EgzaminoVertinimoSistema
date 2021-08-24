import java.util.List;
import java.util.Scanner;

public class Destytojas extends User {

    public Destytojas() {

    }

    @Override
    public String toString() {
        return "Destytojas: \n" +
                "Vardas: " + getName() + "\n" +
                "Pavardė: " + getSurname() + "\n" +
                "ID: " + getId();
    }

    public Destytojas(String name, String surname, int id, String password, boolean isProfessor) {
        super(name, surname, id, password);
        if (isProfessor){
            UserLevel user = UserLevel.PROFESSOR;
        } else {
            System.out.println("Jūs neturite šio lygio prieigos...");
        }
    }


    public boolean register(List <Destytojas> destytojai) {
        Scanner sc = new Scanner(System.in);
        Main main = new Main();
        System.out.println("Sveiki dėstytojau, įveskite savo id:");
        int id = sc.nextInt();
        if (destytojai == null){

        } else {
            for (Destytojas destytojas : destytojai) {
                if (destytojas.getId() == id) {
                    System.out.println("Toks vartotojas jau yra...");
                    return false;
                }
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
        Destytojas destytojas = new Destytojas(name, surname, id, pass, true);
        destytojai.add(destytojas);
        System.out.println("Vartotojas sėkmingai sukurtas.");
        return true;
    }
}
