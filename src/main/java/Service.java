import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

public class Service {
    Scanner sc = new Scanner(System.in);
    StartUp startUp = new StartUp();
    CloseUp closeUp = new CloseUp();

    Student jonas = new Student("Jonas", "Jonaitis", 123, "123", false);
    Destytojas tadas = new Destytojas("Tadas", "Pranauskas", 321, "321", true);

    public void program () {
        startUp.studentai.add(jonas);
        boolean isRunning = true;
        while (isRunning){
            System.out.println("Pasirinkite operacija.");
            System.out.println("1.Prisijungti");
            System.out.println("2.Registruotis");
            System.out.println("3.Iseiti");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    logIn(startUp.destytojai, startUp.studentai, sc, startUp.mapper);
                    isRunning = false;
                }
                case 2 -> register(startUp.destytojai, startUp.studentai, sc);
                case 3 -> isRunning = false;
                default -> System.out.println("Tokio pasirinkimo nera.");
            }
        }
        EgzaminasTestas egzaminasTestas = new EgzaminasTestas(123,"OOP","test");
        closeUp  = new CloseUp(startUp.destytojai, startUp.studentai, startUp.egzaminaiTestai, egzaminasTestas.getWrittenAnswers(),startUp.egzStudEAnswobj);

    }

    private void logIn(List<Destytojas> destytojai, List<Student> studentai, Scanner sc,ObjectMapper mapper) {
        System.out.println("Iveskite savo pareigas:");
        String ocupation = sc.next().toUpperCase(Locale.ROOT);
        if (ocupation.equals("DESTYTOJAS")){
            System.out.println("Sveiki destytojau, iveskite savo Id");
            int id = sc.nextInt();
            for (Destytojas d: destytojai ) {
                if (d.getId() == id){
                    System.out.println("Iveskite savo slaptazodi");
                    String pass = sc.next();
                    if(pass.equals(d.getPassword())){
                        destytojoAplinka(d,mapper);
                        break;
                    } else {
                        System.out.println("Neteisingas slaptazodis.");
                        break;
                    }
                }
            }
        } else if (ocupation.equals("STUDENTAS")){
            System.out.println("Sveiki studente, iveskite savo Id");
            int id = sc.nextInt();
            for (Student s: studentai ) {
                if (s.getId() == id){
                    System.out.println("Iveskite savo slaptazodi");
                    String pass = sc.next();
                    if(pass.equals(s.getPassword())){
                        studentoAplinka(s);
                        break;
                    } else {
                        System.out.println("Neteisingas slaptazodis.");
                        break;
                    }
                }
            }
        }else {
            System.out.println("Neteisingai suvedete pareigas...");
        }
    }

    private void register(List<Destytojas> destytojai, List<Student> studentai, Scanner sc) {
    }

    private void destytojoAplinka(Destytojas d, ObjectMapper mapper) {
        ReadTrueAnswers readTrueAnswers = new ReadTrueAnswers(123,"OOP","test");
        readTrueAnswers.setAnswers(mapper);
    }

    private void studentoAplinka(Student s) {
        System.out.println("1.Laikyti egzamina testa.");
        System.out.println();

        EgzaminasTestas egzaminasTestas = new EgzaminasTestas(123,"OOP","test");
        egzaminasTestas.exam(jonas, sc, closeUp);
        CreateStudentExamAnswerObject createStudentExamAnswerObject = new CreateStudentExamAnswerObject(jonas, egzaminasTestas, egzaminasTestas);
        startUp.egzStudEAnswobj.add(createStudentExamAnswerObject);
    }


}
