import java.util.ArrayList;
import java.util.UUID;

public class Word {

    private String text;
    private String language;
    private String partOfSpeech;
    private String definition;
    private ArrayList<Word> synonyms;
    private ArrayList<Lesson> lessonsIntroduced;
    private UUID id;

    public Word(String text, String language, String partOfSpeech, String definition) {
        this.text = text;
        this.language = language;
        this.partOfSpeech = partOfSpeech;
        this.definition = definition;
        this.synonyms = new ArrayList<>();
        this.lessonsIntroduced = new ArrayList<>();
        this.id = generateUUID();
    }

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

    public UUID generateUUID() {
        return UUID.randomUUID();
    }

    public void setUUID() {
        this.id = generateUUID();
    }
}
