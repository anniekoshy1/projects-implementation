public class TrueFalseQuestion extends Questions {

    private boolean correctAnswer;
    private boolean userAnswer;

    public TrueFalseQuestion(String question, boolean correctAnswer, Difficulty difficulty) {
        super(question, Boolean.toString(correctAnswer), difficulty); 
        this.correctAnswer = correctAnswer;
    }

    public void submitAnswer(boolean userAnswer) {
        this.userAnswer = userAnswer;
    }

    @Override
    public boolean checkAnswer() {
        return this.correctAnswer == this.userAnswer;
    }

    @Override
    public String toString() {
        return getContent() + "\n1. True\n2. False";
    }
}