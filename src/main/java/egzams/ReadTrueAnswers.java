package egzams;

import egzams.Egzam;
import service.CloseUp;

import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class ReadTrueAnswers extends Egzam {

    private final int examId = getExamId();
    private final String examName = getExamName();
    private final String type = getType();
    private String first = "A";
    private String second = "A";
    private String third = "A";
    private String fourth = "A";
    private String fifth = "A";
    private Map <Integer, String> teisingiAts = Map.of(1,first,2,second,3,third,4,fourth,5,fifth);

    public ReadTrueAnswers(int examId, String examName, String type) {
        super(examId, examName, type);
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getThird() {
        return third;
    }

    public void setThird(String third) {
        this.third = third;
    }

    public String getFourth() {
        return fourth;
    }

    public void setFourth(String fourth) {
        this.fourth = fourth;
    }

    public String getFifth() {
        return fifth;
    }

    public void setFifth(String fifth) {
        this.fifth = fifth;
    }

    public Map<Integer, String> getTeisingiAts() {
        return teisingiAts;
    }


    public void readAnswers() {

    }

    public void setAnswers (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Iveskite pirmo atsakymo teisinga varianta:");
        setFirst(sc.next().toUpperCase(Locale.ROOT));
        System.out.println("Iveskite antro atsakymo teisinga varianta:");
        setSecond(sc.next().toUpperCase(Locale.ROOT));
        System.out.println("Iveskite trecio atsakymo teisinga varianta:");
        setThird(sc.next().toUpperCase(Locale.ROOT));
        System.out.println("Iveskite ketvirto atsakymo teisinga varianta:");
        setFourth(sc.next().toUpperCase(Locale.ROOT));
        System.out.println("Iveskite penkto atsakymo teisinga varianta:");
        setFifth(sc.next().toUpperCase(Locale.ROOT));
        teisingiAts.put(1,getFirst());
        teisingiAts.put(2,getSecond());
        teisingiAts.put(3,getThird());
        teisingiAts.put(4,getFourth());
        teisingiAts.put(5,getFifth());
        CloseUp closeUp = new CloseUp();
        closeUp.egzamAnswerCloseUp(teisingiAts);
    }
}
