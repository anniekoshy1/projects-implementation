import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

public class Questions {

    private String content;
    private String correctAnswer;
    private String userAnswer;
    private Difficulty difficulty;
    private UUID questionid;
    private String questionType;

    public Questions(UUID questionID, String content, String correctAnswer, String userAnswer, String questionType, int difficulty) {
        this.questionID = questionID;
        this.content = content;
        this.correctAnswer = correctAnswer;
        this.userAnswer = userAnswer;
        this.questionType = questionType;
        this.difficulty = difficulty;
    }

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("questionID", this.questionID.toString());
        json.put("content", this.content);
        json.put("correctAnswer", this.correctAnswer);
        json.put("userAnswer", this.userAnswer != null ? this.userAnswer : "");
        json.put("questionType", this.questionType);
        json.put("difficulty", this.difficulty);
        return json;
    }

    // Deserialize from JSON
    public static Questions fromJSON(JSONObject json) {
        UUID questionID = UUID.fromString(json.getString("questionID"));
        String content = json.getString("content");
        String correctAnswer = json.getString("correctAnswer");
        String userAnswer = json.getString("userAnswer");
        String questionType = json.getString("questionType");
        int difficulty = json.getInt("difficulty");

        return new Questions(questionID, content, correctAnswer, userAnswer, questionType, difficulty);
    }
    
    public String getContent() {
        return content;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public UUID getId() {
        return id;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public boolean checkAnswer() {
        return correctAnswer.equals(userAnswer);
    }

    public UUID generateUUID() {
        return UUID.randomUUID();
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Question: " + content + "\nDifficulty: " + difficulty + "\nID: " + id;
    }
}