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

    // Methods
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

    public Lesson getNextLesson() {
        // Logic to get the next lesson
        return null;
    }

    public Lesson getPreviousLesson() {
        // Logic to get the previous lesson
        return null;
    }

    public UUID generateUUID() {
        return UUID.randomUUID();
    }

    public void setUUID() {
        this.id = generateUUID();
    }

    public String getRandomContent() {
        // Logic to get random content from historical facts, cultural figures, holidays, or foods
        return "";
    }
}
