import java.util.UUID;

public class Questions {

    private String content;
    private String correctAnswer;
    private String userAnswer;
    private Difficulty difficulty;
    private UUID id;


    public Questions(String content, String correctAnswer, Difficulty difficulty) {
        this.content = content;
        this.correctAnswer = correctAnswer;
        this.difficulty = difficulty;
        this.questionText = questionText;
        this.id = UUID.randomUUID(); 
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