import java.util.ArrayList;
import java.util.UUID;

public class Phrase {

    // Attributes
    private String text;
    private String language;
    private String partOfSpeech;
    private String definition;
    private ArrayList<Word> synonyms;
    private ArrayList<Lesson> lessonsIntroduced;
    private UUID id;

    // Constructor
    public Phrase(String text, String language, String partOfSpeech, String definition) {
        this.text = text;
        this.language = language;
        this.partOfSpeech = partOfSpeech;
        this.definition = definition;
        this.synonyms = new ArrayList<>();
        this.lessonsIntroduced = new ArrayList<>();
        this.id = generateUUID();
    }

    // Methods
    public String getText() {
        return text;
    }

    public String getLanguage() {
        return language;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public String getDefinition() {
        return definition;
    }

    public ArrayList<Word> getSynonyms() {
        return synonyms;
    }

    public void addSynonym(Word synonym) {
        synonyms.add(synonym);
    }

    public ArrayList<Lesson> getLessonsIntroduced() {
        return lessonsIntroduced;
    }

    public void addLessonIntroduced(Lesson lesson) {
        lessonsIntroduced.add(lesson);
    }

    public String getTranslation(String targetLanguage) {
        // Logic to get translation of the phrase in the target language
        return "";
    }

    public void addTranslation(String targetLanguage, String translation) {
        // Logic to add translation for the phrase in a specific language
    }

    public UUID generateUUID() {
        return UUID.randomUUID();
    }

    public void setUUID() {
        this.id = generateUUID();
    }
}
