import java.util.ArrayList;
import java.util.Collections;

public class StarterTest {

    private ArrayList<Questions> questions;
    private int score;

    public StarterTest() {
        this.questions = new ArrayList<>();
        this.score = 0;
    }

    public Questions getQuestion() {
        if (!questions.isEmpty()) {
            return questions.remove(0);
        }
        return null;
    }

    public boolean hasMoreQuestions() {
        return !questions.isEmpty();
    }

    public void gotRight() {
        score++;
    }

    public void gotWrong() {
    }

    public int getScore() {
        return score;
    }

    public void resetTest() {
        this.score = 0;
        Collections.shuffle(questions);
    }
}