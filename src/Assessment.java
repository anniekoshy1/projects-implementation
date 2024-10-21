import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Assessment {

    public enum AssessmentType {
        MULTIPLE_CHOICE,
        TRUE_FALSE,
        OPEN_ENDED
    }

    private AssessmentType type;
    private int userScore;
    private List<Questions> questions;
    private ArrayList<Assessment> completedAssessments;
    private int attempts;
    private UUID id;

    public Assessment(AssessmentType type, List<Questions> questions) {
        this.type = type;
        this.userScore = 0;
        this.questions = questions;
        this.completedAssessments = new ArrayList<>();
        this.attempts = 0;
        this.id = UUID.randomUUID(); 
    }

    public Assessment(UUID id, String type, String userScore, int attempts){
        this.id = id;
        this.type = AssessmentType.valueOf(type.toUpperCase());
        this.userScore = Integer.parseInt(userScore);
        this.attempts = attempts;
    }
    public void startAssessment() {
        System.out.println("Assessment of type " + type + " started.");
    }

    public int calculateScore() {
        int correctAnswers = 0;
        for (Questions question : questions) {
            if (question.checkAnswer()) {
                correctAnswers++;
            }
        }
        this.userScore = (int) ((double) correctAnswers / questions.size() * 100);  
        return userScore;
    }

    public int getResults() {
        return userScore;
    }

    public int calculateRating() {
        if (userScore >= 90) {
            return 5;  
        } else if (userScore >= 80) {
            return 4;
        } else if (userScore >= 70) {
            return 3;
        } else if (userScore >= 60) {
            return 2;
        } else {
            return 1;  
        }
    }

    public void retakeAssessment() {
        attempts++;
        this.userScore = 0;
        System.out.println("Retake attempt " + attempts + " started.");
    }

    public UUID generateUUID() {
        return UUID.randomUUID();
    }

    public void setUUID(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void markAsCompleted() {
        completedAssessments.add(this);
        System.out.println("Assessment completed.");
    }

    public AssessmentType getAssessmentType() {
        return type;
    }

    public void setAssessmentType(AssessmentType type) {
        this.type = type;
    }
}