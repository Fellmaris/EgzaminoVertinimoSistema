package service;

import egzams.EgzaminasTestas;
import egzams.ReadTrueAnswers;
import users.Destytojas;
import users.Student;

import java.util.*;

public class Service {
    final private String destytojoSlaptazodis = "123";
    public void program () {
        StartUp startUp = new StartUp();
        Student jonas = new Student("Jonas", "Jonaitis", 123, "123", false);
        Destytojas pranas = new Destytojas("Pranas", "Pranaitis", 321, "321", true);
        startUp.studentai.add(jonas);
        startUp.destytojai.add(pranas);
        boolean isRunning = true;
        while (isRunning){
            System.out.println("Pasirinkite operacija.");
            System.out.println("1.Prisijungti");
            System.out.println("2.Registruotis");
            System.out.println("3.Iseiti");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    logIn(startUp.destytojai, startUp.studentai,sc);
                    isRunning = false;
                    break;
                case 2:
                    register(startUp.destytojai, startUp.studentai,sc);
                    break;
                case 3:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Tokio pasirinkimo nera.");
                    break;
            }
        }
        EgzaminasTestas egzaminasTestas = new EgzaminasTestas(123,"OOP","test");
        CloseUp closeUp  = new CloseUp(startUp.destytojai, startUp.studentai, startUp.egzaminaiTestai, egzaminasTestas.getWrittenAnswers());

    }

    private void logIn(List<Destytojas> destytojai, List<Student> studentai, Scanner sc) {
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
                        destytojoAplinka(d);
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
        System.out.println("Ar registruojat??s kaip destytojas ar studentas?");
        String position = sc.next();
        if (position.toLowerCase(Locale.ROOT).equals("destytojas")){
          Destytojas destytojas = new Destytojas();
          destytojas.register(destytojai);
        } else if (position.toLowerCase(Locale.ROOT).equals("studentas")){
            Student student = new Student();
            student.register(studentai);
        }
    }

    private void destytojoAplinka(Destytojas d) {
        System.out.println("Sveiki destytojau: " + d.getName() + " " + d.getSurname());
        ReadTrueAnswers readTrueAnswers = new ReadTrueAnswers(123,"OOP","test");
        readTrueAnswers.setAnswers();
    }

    private void studentoAplinka(Student s) {
        System.out.println("Sveiki studente: " + s.getName() + " " + s.getSurname());
        EgzaminasTestas egzaminasTestas = new EgzaminasTestas(123,"OOP","test");
        egzaminasTestas.exam();
        List <Map> studentoEgzaminaiIrAtsakymai = new ArrayList<>();
        studentoEgzaminaiIrAtsakymai.add(egzaminasTestas.getWrittenAnswers());
    }


}
