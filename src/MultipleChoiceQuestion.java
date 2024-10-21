import java.util.ArrayList;
import java.util.Collections;

public class MultipleChoiceQuestion extends Questions {

    private ArrayList<String> options;
    private int correctAnswerIndex;
    private int usersAnswerIndex;

    public MultipleChoiceQuestion(String question, ArrayList<String> options, int correctAnswerIndex, Difficulty difficulty) {
        super(question, options.get(correctAnswerIndex), difficulty); 
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
        this.usersAnswerIndex = -1; 
    }

    public String getCorrectAnswer() {
        return options.get(correctAnswerIndex);
    }

    public void setUsersAnswer(int index) {
        if (index >= 0 && index < options.size()) {
            this.usersAnswerIndex = index;
        } else {
            System.out.println("Invalid answer index.");
        }
    }

    public boolean checkAnswer() {
        return this.usersAnswerIndex == this.correctAnswerIndex;
    }

    public void shuffleQuestions() {
        Collections.shuffle(options);
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    @Override
    public String toString() {
        StringBuilder questionDisplay = new StringBuilder(getContent() + "\n");
        for (int i = 0; i < options.size(); i++) {
            questionDisplay.append(i + 1).append(". ").append(options.get(i)).append("\n");
        }
        return questionDisplay.toString();
    }
}