package egzams;

public class Egzam {
    private int examId;
    private String examName;
    private String type;

    public Egzam() {
    }

    public Egzam(int examId, String examName, String type) {
        this.examId = examId;
        this.examName = examName;
        this.type = type;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
