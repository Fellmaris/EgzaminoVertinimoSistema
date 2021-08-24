import java.util.*;

public class Service {
    Scanner sc = new Scanner(System.in);
    List <Map> studentoEgzaminaiIrAtsakymai = new ArrayList<>();

    public void program () {
        StartUp startUp = new StartUp();
        Student jonas = new Student("Jonas", "Jonaitis", 123, "123", false);
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
                    logIn(startUp.destytojai, startUp.studentai, sc);
                    isRunning = false;
                }
                case 2 -> register(startUp.destytojai, startUp.studentai, sc);
                case 3 -> isRunning = false;
                default -> System.out.println("Tokio pasirinkimo nera.");
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
    }

    private void destytojoAplinka(Destytojas d) {
        ReadTrueAnswers readTrueAnswers = new ReadTrueAnswers(123,"OOP","test");
        readTrueAnswers.setAnswers();
    }

    private void studentoAplinka(Student s) {
        EgzaminasTestas egzaminasTestas = new EgzaminasTestas(123,"OOP","test");
        egzaminasTestas.exam(sc);
        studentoEgzaminaiIrAtsakymai.add(egzaminasTestas.writtenAnswers);
    }


}
