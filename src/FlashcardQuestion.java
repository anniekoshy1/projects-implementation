public class FlashcardQuestion extends Questions {

    // Attributes
    private String frontInfo;
    private String backAnswer;
    private String userAnswer;

    // Constructor
    public FlashcardQuestion(String frontInfo, String backAnswer) {
        super(frontInfo, backAnswer, Difficulty.Rudimentary);  // Assuming difficulty is set to 0 for now
        this.frontInfo = frontInfo;
        this.backAnswer = backAnswer;
    }

    // Methods
    public void flipCard() {
        // No code for now (Could print both sides)
    }

    public void showDefinition() {
        // No code for now (Logic to show the back side)
    }

    public void submitAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public boolean checkAnswer() {
        return backAnswer.equals(userAnswer);
    }

    public void showCorrectAnswer() {
        // No code for now (Could show the correct answer)
    }

    public void reset() {
        this.userAnswer = null;
    }
}