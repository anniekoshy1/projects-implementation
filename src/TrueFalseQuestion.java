public class TrueFalseQuestion extends Questions {

    private boolean correctAnswer;
    private boolean userAnswer;

    public TrueFalseQuestion(String question, boolean correctAnswer) {
        super(question, Boolean.toString(correctAnswer), 0); 
        this.correctAnswer = correctAnswer;
    }

    public void submitAnswer(boolean userAnswer) {
        this.userAnswer = userAnswer;
    }

    public boolean checkAnswer() {
        return this.correctAnswer == this.userAnswer;
    }

}
