import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Assessment {

    // Enumeration for the type of assessment (e.g., Multiple Choice, True/False, etc.)
    public enum AssessmentType {
        MULTIPLE_CHOICE, TRUE_FALSE, OPEN_ENDED, MATCHING
    }

    private AssessmentType type;  // Type of the assessment
    private int userScore;  // User's score on the assessment
    private List<Questions> questions;  // List of questions in the assessment
    private int attempts;  // Number of attempts user has made
    private UUID id;  // Unique ID for the assessment

    // Constructor for creating a new Assessment
    public Assessment(UUID id, AssessmentType type, List<Questions> questions) {
        this.id = id;
        this.type = type;
        this.userScore = 0;
        this.attempts = 0;
        this.questions = questions;
    }

    // Getter for the assessment results (user score)
    public int getResults() {
        return userScore;
    }

    // Calculate the score for the assessment based on correct answers
    public int calculateScore() {
        int correctAnswers = 0;
        for (Questions question : questions) {
            if (question.checkAnswers()) {
                correctAnswers++;
            }
        }
        this.userScore = (int) ((double) correctAnswers / questions.size() * 100);  // Calculate score as a percentage
        return userScore;
    }

    // Calculate the user's rating based on the score (1 to 5 stars)
    public int calculateRating() {
        if (userScore >= 90) {
            return 5;  // 5-star rating
        } else if (userScore >= 80) {
            return 4;  // 4-star rating
        } else if (userScore >= 70) {
            return 3;  // 3-star rating
        } else if (userScore >= 60) {
            return 2;  // 2-star rating
        } else {
            return 1;  // 1-star rating
        }
    }

    // Method to allow user to retake the assessment
    public void retakeAssessment() {
        attempts++;  // Increment the number of attempts
        this.userScore = 0;  // Reset the score for the retake
    }

    // Generate a new UUID for the assessment
    public UUID generateUUID() {
        return UUID.randomUUID();
    }

    // Getter for the assessment ID
    public UUID getId() {
        return id;
    }

    // Setter for the assessment ID
    public void setUUID(UUID id) {
        this.id = id;
    }

    // Getter for the list of questions
    public List<Questions> getQuestions() {
        return questions;
    }

    // Setter for the list of questions
    public void setQuestions(List<Questions> questions) {
        this.questions = questions;
    }

    // Getter for the assessment type
    public AssessmentType getType() {
        return type;
    }

    // Setter for the assessment type
    public void setType(AssessmentType type) {
        this.type = type;
    }

    // Getter for the number of attempts
    public int getAttempts() {
        return attempts;
    }

    // Setter for the number of attempts
    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }
}