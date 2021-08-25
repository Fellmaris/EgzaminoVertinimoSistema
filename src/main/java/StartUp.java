import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StartUp {

    public List <Destytojas> destytojai = new ArrayList<>();
    public List <Student>studentai = new ArrayList<>();
    public List <EgzaminasTestas> egzaminaiTestai = new ArrayList<>();
    public List<CreateStudentExamAnswerObject> egzStudEAnswobj = new ArrayList<>();
    public Map <Integer,String> teisingiAts;

    public ObjectMapper mapper = new ObjectMapper();

    public StartUp() {
        File destytojaiFile = new File("destytojai.json");
        File studentaiFile = new File("studentai.jason");
        File egzaminuFile = new File("egzaminai.json");
        File trueAnswersFile = new File("egzaminoAts.json");
        File studentEgzaminaiIrAtsakymaiFile = new File("studEgzAndAnswr.json");
        File egzStudEAnswobjFile = new File("studentEgzamAndAnswerObjects.json");
        try {
            if (!studentEgzaminaiIrAtsakymaiFile.exists()) {
                destytojaiFile.createNewFile();
            }
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
            if (!trueAnswersFile.exists()) {
                egzaminuFile.createNewFile();
            }
            if (!egzStudEAnswobjFile.exists()) {
                egzaminuFile.createNewFile();
            }

        } catch (IOException e) {
            System.out.println("Nepavyko sukurti failų. " + e);
        }
        ReadTrueAnswers readTrueAnswers = new ReadTrueAnswers(123,"OOP","test");
        teisingiAts = readTrueAnswers.getTeisingiAts();

        try {
            System.out.println("Nuskaitomi failai...");
            egzStudEAnswobj = (mapper.readValue(egzStudEAnswobjFile, new TypeReference<>() {}));
            destytojai = (mapper.readValue(destytojaiFile, new TypeReference<>() {}));
            studentai = (mapper.readValue(studentaiFile, new TypeReference<>() {}));
            egzaminaiTestai = mapper.readValue(egzaminuFile, new TypeReference<>() {});
            teisingiAts = mapper.readValue(trueAnswersFile, new TypeReference<>() {});

        } catch (IOException e){
            System.out.println("Nepavyko nuskaityti failų... " + e);
        }
    }
}
