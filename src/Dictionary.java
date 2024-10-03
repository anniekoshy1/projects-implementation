import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {

    // Attributes
    private HashMap<Word, Word> fromEnglish;
    private ArrayList<String> languages;
    private HashMap<Lesson, ArrayList<Word>> lessonWords;

    // Constructor
    public Dictionary(ArrayList<String> languages) {
        this.languages = languages;
        this.fromEnglish = new HashMap<>();
        this.lessonWords = new HashMap<>();
    }

    // Methods
    public void addWord(Word englishWord, Word translatedWord) {
        fromEnglish.put(englishWord, translatedWord);
    }

    public void removeWord(Word englishWord) {
        fromEnglish.remove(englishWord);
    }

    public Word getTranslation(Word englishWord, String targetLanguage) {
        // Logic to get translation based on target language
        return fromEnglish.get(englishWord); 
    }

    public ArrayList<Word> getWordsForLesson(Lesson lesson) {
        return lessonWords.getOrDefault(lesson, new ArrayList<>());
    }

    public HashMap<Word, Word> getAllTranslations() {
        return fromEnglish;
    }

    public void addLanguage(String language) {
        if (!languages.contains(language)) {
            languages.add(language);
        }
    }

    public ArrayList<String> getAvailableLanguages() {
        return languages;
    }
}
