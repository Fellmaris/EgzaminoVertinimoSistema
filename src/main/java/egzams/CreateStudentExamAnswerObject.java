package egzams;

import service.CloseUp;
import users.Student;

import java.util.ArrayList;
import java.util.List;

public class CreateStudentExamAnswerObject {
    public List<Object> egzamObj = new ArrayList<>();
    Student student;
    Egzam egzam;
    EgzaminasTestas ats;
    Result res;


    public CreateStudentExamAnswerObject(Student studentas, Egzam egzaminas, EgzaminasTestas answers ) {
        student = studentas;
        egzam = egzaminas;
        ats = answers;
        egzamObj.add(studentas);
        egzamObj.add(egzaminas);
        egzamObj.add(answers);
        ReadTrueAnswers readTrueAnswers = new ReadTrueAnswers(egzaminas.getExamId(),egzaminas.getExamName(),egzaminas.getType());
        Result result = new Result(answers.getWrittenAnswers(), readTrueAnswers.getTeisingiAts());
        int result1 = result.result;
        egzamObj.add(result1);
        CloseUp closeUp = new CloseUp();
        closeUp.egzamCloseUp(egzamObj);

    }
}
