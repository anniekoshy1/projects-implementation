import java.util.ArrayList;

public class MultipleChoiceQuestion extends Questions {

    // Attributes
    private String question;
    private ArrayList<String> options;
    private int correctAnswer;
    private int usersAnswer;

    // Constructor
    public MultipleChoiceQuestion(String question, int correctAnswer, ArrayList<String> options) {
        super(question, options.get(correctAnswer), 0);  // Assuming difficulty is set to 0 for now
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.options = options;
    }

    // Methods
    public String getCorrectAnswer() {
        return options.get(correctAnswer);
    }

    public boolean checkAnswer(int usersAnswer) {
        return this.correctAnswer == usersAnswer;
    }

    public void shuffleQuestions() {
        // No code for now 
    }
}
