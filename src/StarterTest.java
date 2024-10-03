import java.util.ArrayList;

public class StarterTest {

    // Attributes
    private ArrayList<Questions> questions;
    private int score;

    // Constructor
    public StarterTest() {
        this.questions = new ArrayList<>();
        this.score = 0;
    }

    // Methods
    public Questions getQuestion() {
        // Logic to return a question from the list
        return questions.isEmpty() ? null : questions.get(0);
    }

    public boolean hasMoreQuestions() {
        return !questions.isEmpty();
    }

    public void gotRight() {
        score++;
    }

    public void gotWrong() {
        // No code for now
    }

    public int getScore() {
        return score;
    }

    public void resetTest() {
        this.score = 0;
        // Logic to reset the test, like shuffling questions if needed
    }
}
