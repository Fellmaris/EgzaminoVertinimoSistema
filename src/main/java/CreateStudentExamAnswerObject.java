import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CreateStudentExamAnswerObject implements Serializable {

    Student student;
    Egzam egzam;
    int results;

    public CreateStudentExamAnswerObject() {
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Egzam getEgzam() {
        return egzam;
    }

    public void setEgzam(Egzam egzam) {
        this.egzam = egzam;
    }


    public int getResults() {
        return results;
    }

    public void setResults(int results) {
        this.results = results;
    }

    public CreateStudentExamAnswerObject(Student studentas, Egzam egzaminas, EgzaminasTestas answers ) {
        student = studentas;
        egzam = egzaminas;
        ReadTrueAnswers readTrueAnswers = new ReadTrueAnswers(egzaminas.getExamId(),egzaminas.getExamName(),egzaminas.getType());
        Result result = new Result(answers.getWrittenAnswers(), readTrueAnswers.getTeisingiAts());
        results = result.result;
    }
}
