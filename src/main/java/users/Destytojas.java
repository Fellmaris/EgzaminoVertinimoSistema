package users;

import java.util.List;
import java.util.Scanner;

public class Destytojas extends User {

    public Destytojas() {

    }

    @Override
    public String toString() {
        return "users.Destytojas: \n" +
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
        Destytojas destytojasTemp = (Destytojas) enterData(sc, id, true);
        Destytojas destytojas = new Destytojas(destytojasTemp.getName(), destytojasTemp.getSurname(), id, destytojasTemp.getPassword(), true);
        destytojai.add(destytojas);
        System.out.println("Vartotojas sėkmingai sukurtas.");
        return true;
    }
}
