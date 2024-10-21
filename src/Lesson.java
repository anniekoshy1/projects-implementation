import java.util.ArrayList;
import java.util.UUID;

public class Lesson {

    // Attributes
    private double lessonProgress;
    private String description;
    private ArrayList<Word> words;
    private Dictionary topic;  
    private ArrayList<Questions> questions;
    private ArrayList<String> historicalFacts;
    private ArrayList<String> culturalFigures;
    private ArrayList<String> holidays;
    private ArrayList<String> foods;
    private UUID id;

    // Constructor
    public Lesson(String description) {
        this.description = description;
        this.lessonProgress = 0.0;
        this.words = new ArrayList<>();
        this.questions = new ArrayList<>();
        this.historicalFacts = new ArrayList<>();
        this.culturalFigures = new ArrayList<>();
        this.holidays = new ArrayList<>();
        this.foods = new ArrayList<>();
        this.id = generateUUID();
    }
    // Getter for topic
    public Dictionary getTopic() {
        return topic;
    }

    // Setter for topic
    public void setTopic(Dictionary topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }
    
    // Setters and Getters
    public void setDescription(String description) {
        this.description = description;
    }

    public double getLessonProgress() {
        return lessonProgress;
    }

    public void setLessonProgress(double progress) {
        this.lessonProgress = progress;
    }

    public ArrayList<Word> getWords() {
        return words;
    }

    public void addWord(Word word) {
        words.add(word);
    }

    public ArrayList<Questions> getQuestions() {
        return questions;
    }

    public void addQuestion(Questions question) {
        questions.add(question);
    }

    public Lesson getNextLesson(Course course) {
        
        return null;  
    }

    public Lesson getPreviousLesson(Course course) {
    
        return null;  
    }

    public UUID generateUUID() {
        return UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public String getRandomContent() {
        // Logic to get random content from available lists
        ArrayList<String> combinedContent = new ArrayList<>();
        combinedContent.addAll(historicalFacts);
        combinedContent.addAll(culturalFigures);
        combinedContent.addAll(holidays);
        combinedContent.addAll(foods);

        if (!combinedContent.isEmpty()) {
            int randomIndex = (int) (Math.random() * combinedContent.size());
            return combinedContent.get(randomIndex);
        }
        return "No content available";
    }
    @Override
    public String toString() {
    return "Lesson Description: " + description;
    }
}