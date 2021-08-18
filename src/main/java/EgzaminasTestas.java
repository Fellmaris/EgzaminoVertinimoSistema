import java.util.*;

public class EgzaminasTestas extends Egzam{

    private String firstAnswer;
    private String secondAnswer;
    private String thirdAnswer;
    private String fourthAnswer;
    private String fifthAnswer;
    private final int questionOne = 1;
    private final int questionTwo = 2;
    private final int questionThree = 3;
    private final int questionFour = 4;
    private final int questionFive = 5;
    Map <Integer, String> writtenAnswers = new HashMap<>();

    public EgzaminasTestas(int examId, String examName, String type) {
        super(examId, examName, type);
    }

    public String getFirstAnswer() {
        return firstAnswer;
    }

    public void setFirstAnswer(String firstAnswer) {
        this.firstAnswer = firstAnswer;
    }

    public String getSecondAnswer() {
        return secondAnswer;
    }

    public void setSecondAnswer(String secondAnswer) {
        this.secondAnswer = secondAnswer;
    }

    public String getThirdAnswer() {
        return thirdAnswer;
    }

    public void setThirdAnswer(String thirdAnswer) {
        this.thirdAnswer = thirdAnswer;
    }

    public String getFourthAnswer() {
        return fourthAnswer;
    }

    public void setFourthAnswer(String fourthAnswer) {
        this.fourthAnswer = fourthAnswer;
    }

    public String getFifthAnswer() {
        return fifthAnswer;
    }

    public void setFifthAnswer(String fifthAnswer) {
        this.fifthAnswer = fifthAnswer;
    }

    public int getQuestionOne() {
        return questionOne;
    }

    public int getQuestionTwo() {
        return questionTwo;
    }

    public int getQuestionThree() {
        return questionThree;
    }

    public int getQuestionFour() {
        return questionFour;
    }

    public int getQuestionFive() {
        return questionFive;
    }



    public Map<Integer, String> getWrittenAnswers() {
        return writtenAnswers;
    }

    public void setWrittenAnswers(Map<Integer, String> writtenAnswers) {
        this.writtenAnswers = writtenAnswers;
    }


    public void exam(){
        setExamId(123);
        setExamName("OOP");
        setType("Test");
        Scanner sc = new Scanner(System.in);
        System.out.println("Sveiki atvyke i: " + getExamName() + " egzamina");
        System.out.println("1. Pirmas klausimas");
        System.out.println("A");
        System.out.println("B");
        System.out.println("C");
        firstAnswer = sc.next().toUpperCase(Locale.ROOT);
        writtenAnswers.put(1, firstAnswer);

        System.out.println("2. Antras klausimas");
        System.out.println("A");
        System.out.println("B");
        System.out.println("C");
        secondAnswer = sc.next().toUpperCase(Locale.ROOT);
        writtenAnswers.put(2, secondAnswer);

        System.out.println("3. Trecias klausimas");
        System.out.println("A");
        System.out.println("B");
        System.out.println("C");
        thirdAnswer = sc.next().toUpperCase(Locale.ROOT);
        writtenAnswers.put(3, thirdAnswer);

        System.out.println("4. Ketvirtas klausimas");
        System.out.println("A");
        System.out.println("B");
        System.out.println("C");
        fourthAnswer = sc.next().toUpperCase(Locale.ROOT);
        writtenAnswers.put(4, fourthAnswer);

        System.out.println("5. Penktas klausimas");
        System.out.println("A");
        System.out.println("B");
        System.out.println("C");
        fifthAnswer = sc.next().toUpperCase(Locale.ROOT);
        writtenAnswers.put(5, fifthAnswer);

        CloseUp closeUp = new CloseUp();
        List<Object> writtenAnswersList = new ArrayList<>();
        writtenAnswersList.add(writtenAnswers);
        closeUp.setWrittenAnswers(writtenAnswersList);
    }
}
