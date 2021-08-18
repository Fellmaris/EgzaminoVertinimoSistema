import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CloseUp {
    List<Object> writtenAnswers = new ArrayList<>();

    public List<Object> getWrittenAnswers() {
        return writtenAnswers;
    }

    public void setWrittenAnswers(List<Object> writtenAnswers) {
        this.writtenAnswers = writtenAnswers;
    }

    public CloseUp() {
    }

    public CloseUp(List destytojai, List studentai, List egzaminoAts, Map trueAnswers) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        File destytojaiFile = new File("destytojai.json");
        File studentaiFile = new File("studentai.jason");
        File egzaminuFile = new File("egzaminai.json");
        try {
            if (!destytojaiFile.exists()) {
                System.out.println("Kuriamas dėstytoju failas...");
                destytojaiFile.createNewFile();
            }
            if (!studentaiFile.exists()) {
                System.out.println("Kuriamas studentų failas...");
                studentaiFile.createNewFile();
            }
            if (!egzaminuFile.exists()) {
                System.out.println("Kuriamas egzaminų laikymo failas...");
                egzaminuFile.createNewFile();
            }

        } catch (IOException e) {
            System.out.println("Nepavyko sukurti failų. " + e);
        }

        try {
            System.out.println("Įrašomi failai...");
            mapper.writeValue(destytojaiFile, destytojai);
            mapper.writeValue(studentaiFile, studentai);
        }catch (IOException e){
            System.out.println("Nepavyko įrašyti failų. " + e);
        }

        System.out.println("Programa baigia darbą...");
    }

    public void egzamCloseUp(List<Object> studentoAts) {
        ObjectMapper mapper = new ObjectMapper();
        File trueAnswersFile = new File("egzaminai.json");
        try {
            if (!trueAnswersFile.exists()) {
                System.out.println("Kuriamas egzaminų atsakymų failas...");
                trueAnswersFile.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Nepavyko sukurti studento atsakymu failo...");
        }
        try {
            mapper.writeValue(trueAnswersFile, studentoAts);
        } catch (IOException e){
            System.out.println("Nepavyko irasyti i atsakymu faila... " + e);
        }
    }

    public void egzamAnswerCloseUp(Map<Integer,String> egzamAnswers){
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        File egzaminuAtsFile = new File("egzaminai.json");
        try {
            if (!egzaminuAtsFile.exists()) {
                System.out.println("Kuriamas egzaminų laikymo failas...");
                egzaminuAtsFile.createNewFile();
            }
        }catch (IOException e){
            System.out.println("Nepavyko sukurti atsakymu failo... " + e);
        }
        try {
            mapper.writeValue(egzaminuAtsFile, egzamAnswers);
        } catch (IOException e){
            System.out.println("Nepavyko irasyti egzamino teisingu atsakymu... " + e);
        }
    }
}
