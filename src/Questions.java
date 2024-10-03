import java.util.ArrayList;
import java.util.UUID;

public class Questions {

    // Attributes
    private String content;
    private String correctAnswer;
    private String userAnswer;
    private int difficulty;
    private ArrayList<Questions> questions;
    private UUID id;

    // Constructor
    public Questions(String content, String correctAnswer, int difficulty) {
        this.content = content;
        this.correctAnswer = correctAnswer;
        this.difficulty = difficulty;
        this.questions = new ArrayList<>();
        this.id = UUID.randomUUID();
    }

    public String getContent() {
        return content;
    }

    public ArrayList<Questions> getQuestions() {
        return questions;
    }

    public String toString() {
        return "Question: " + content + "\nDifficulty: " + difficulty;
    }

    // Other methods
    public boolean checkAnswers() {
        return correctAnswer.equals(userAnswer);
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty.ordinal(); // Assuming Difficulty is an enum
    }

    public UUID generateUUID() {
        return UUID.randomUUID();
    }

    public void setUUID(UUID id) {
        this.id = id;
    }
}
