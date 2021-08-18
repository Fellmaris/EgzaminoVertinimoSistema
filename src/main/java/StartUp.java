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

    public StartUp() {
        File destytojaiFile = new File("destytojai.json");
        File studentaiFile = new File("studentai.jason");
        File egzaminuFile = new File("egzaminai.json");
        File trueAnswersFile = new File("egzaminoAts.json");
        ObjectMapper mapper = new ObjectMapper();
        ReadTrueAnswers readTrueAnswers = new ReadTrueAnswers(123,"OOP","test");
        Map <Integer,String> teisingiAts = readTrueAnswers.getTeisingiAts();
        try {
            System.out.println("Nuskaitomi failai...");
            destytojai = (mapper.readValue(destytojaiFile, new TypeReference<>() {
            }));
            studentai = (mapper.readValue(studentaiFile, new TypeReference<>() {
            }));
            egzaminaiTestai = mapper.readValue(egzaminuFile, new TypeReference<>() {
            });
            teisingiAts = mapper.readValue(trueAnswersFile, new TypeReference<>() {
            });

        } catch (IOException e){
            System.out.println("Nepavyko nuskaityti failų... " + e);
        }
    }
}
