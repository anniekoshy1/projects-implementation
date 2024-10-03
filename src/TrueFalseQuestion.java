public class TrueFalseQuestion extends Questions {

    // Attributes
    private boolean correctAnswer;
    private boolean userAnswer;

    // Constructor
    public TrueFalseQuestion(String question, boolean correctAnswer) {
        super(question, Boolean.toString(correctAnswer), 0);  // Assuming difficulty is set to 0 for now
        this.correctAnswer = correctAnswer;
    }

    // Methods
    public void submitAnswer(boolean userAnswer) {
        this.userAnswer = userAnswer;
    }

    public boolean checkAnswer() {
        return this.correctAnswer == this.userAnswer;
    }

}
