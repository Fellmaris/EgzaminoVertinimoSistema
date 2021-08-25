import java.io.Serializable;
import java.util.*;

public class EgzaminasTestas extends Egzam implements Serializable {


    Map <Integer, String> writtenAnswers = new HashMap<>();
    List<Object> writtenAnswersList = new ArrayList<>();

    public EgzaminasTestas() {
    }

    public EgzaminasTestas(int examId, String examName, String type) {
        super(examId, examName, type);
    }





    public Map<Integer, String> getWrittenAnswers() {
        return writtenAnswers;
    }

    public void setWrittenAnswers(Map<Integer, String> writtenAnswers) {
        this.writtenAnswers = writtenAnswers;
    }


    public void exam(Student student, Scanner sc, CloseUp closeUp){
        if (!student.takeEgzamTimer(new Date())){
            System.out.println("You need to wait for " + student.waitingTime(new Date()) + " to be able to take this egzam again");
            return;
        }
        setExamId(123);
        setExamName("OOP");
        setType("Test");
        System.out.println("Sveiki atvyke i: " + getExamName() + " egzamina");
        System.out.println("1. Pirmas klausimas");
        System.out.println("A");
        System.out.println("B");
        System.out.println("C");
        String firstAnswer = sc.next().toUpperCase(Locale.ROOT);
        writtenAnswers.put(1, firstAnswer);

        System.out.println("2. Antras klausimas");
        System.out.println("A");
        System.out.println("B");
        System.out.println("C");
        String secondAnswer = sc.next().toUpperCase(Locale.ROOT);
        writtenAnswers.put(2, secondAnswer);

        System.out.println("3. Trecias klausimas");
        System.out.println("A");
        System.out.println("B");
        System.out.println("C");
        String thirdAnswer = sc.next().toUpperCase(Locale.ROOT);
        writtenAnswers.put(3, thirdAnswer);

        System.out.println("4. Ketvirtas klausimas");
        System.out.println("A");
        System.out.println("B");
        System.out.println("C");
        String fourthAnswer = sc.next().toUpperCase(Locale.ROOT);
        writtenAnswers.put(4, fourthAnswer);

        System.out.println("5. Penktas klausimas");
        System.out.println("A");
        System.out.println("B");
        System.out.println("C");
        String fifthAnswer = sc.next().toUpperCase(Locale.ROOT);
        writtenAnswers.put(5, fifthAnswer);

        writtenAnswersList.add(writtenAnswers);
        closeUp.setWrittenAnswers(writtenAnswersList);

    }
}
