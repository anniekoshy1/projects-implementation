public class FlashcardQuestion {

    private String frontInfo;  // The front of the flashcard 
    private String backAnswer;  // The back of the flashcard
    private String userAnswer;  // The user's input or guess

    public FlashcardQuestion(String frontInfo, String backAnswer) {
        this.frontInfo = frontInfo;
        this.backAnswer = backAnswer;
        this.userAnswer = "";
    }

    public void flipCard() {
        System.out.println("Flipped! The answer is: " + backAnswer);
    }

    // Show the definition or answer on the back of the card
    public String showDefinition() {
        return backAnswer;
    }

    // Submit an answer for the flashcard question
    public void submitAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    // Check if the user's answer is correct
    public boolean checkAnswer() {
        return userAnswer.equalsIgnoreCase(backAnswer);
    }

    // Show the correct answer
    public String showCorrectAnswer() {
        return backAnswer;
    }

    public void reset() {
        this.userAnswer = "";
    }

    // Getters for the flashcard information
    public String getFrontInfo() {
        return frontInfo;
    }

    public String getBackAnswer() {
        return backAnswer;
    }

    public String getUserAnswer() {
        return userAnswer;
    }
}