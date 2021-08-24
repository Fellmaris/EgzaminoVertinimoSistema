import java.util.ArrayList;
import java.util.List;

public class CreateStudentExamAnswerObject {

    Student student;
    Egzam egzam;
    EgzaminasTestas ats;
    int results;


    public CreateStudentExamAnswerObject(Student studentas, Egzam egzaminas, EgzaminasTestas answers ) {
        student = studentas;
        egzam = egzaminas;
        ats = answers;
        ReadTrueAnswers readTrueAnswers = new ReadTrueAnswers(egzaminas.getExamId(),egzaminas.getExamName(),egzaminas.getType());
        Result result = new Result(answers.getWrittenAnswers(), readTrueAnswers.getTeisingiAts());
        results = result.result;
    }
}
