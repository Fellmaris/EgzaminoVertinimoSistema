package egzams;

import java.util.Map;

public class Result {

    public int result = 0;

        public Result(Map writtenAnswers, Map trueAnswers) {
            if (writtenAnswers.get(1).equals(trueAnswers.get(1))){
                result += 2;
            }
            if (writtenAnswers.get(2).equals(trueAnswers.get(2))){
                result += 2;
            }
            if (writtenAnswers.get(3).equals(trueAnswers.get(3))){
                result += 2;
            }
            if (writtenAnswers.get(4).equals(trueAnswers.get(4))){
                result += 2;
            }
            if (writtenAnswers.get(5).equals(trueAnswers.get(5))){
                result += 2;
            }
    }

}
