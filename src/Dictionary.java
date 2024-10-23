import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {

    private HashMap<Word, Word> fromEnglish;
    private ArrayList<String> languages;
    private HashMap<Lesson, ArrayList<Word>> lessonWords;

    public Dictionary(ArrayList<String> languages) {
        this.languages = languages;
        this.fromEnglish = new HashMap<>();
        this.lessonWords = new HashMap<>();
    }

    public void addWord(Word englishWord, Word translatedWord) {
        fromEnglish.put(englishWord, translatedWord);
    }

    public void removeWord(Word englishWord) {
        fromEnglish.remove(englishWord);
    }

    // Get the translation of a word from English to a target language
    public Word getTranslation(Word englishWord, String targetLanguage) {
        Word translatedWord = fromEnglish.get(englishWord);
        if (translatedWord != null && translatedWord.getLanguage().equalsIgnoreCase(targetLanguage)) {
            return translatedWord;
        }
        return null;  // Return null if no translation is found
    }

    // Get all words associated with a specific lesson
    public ArrayList<Word> getWordsForLesson(Lesson lesson) {
        return lessonWords.getOrDefault(lesson, new ArrayList<>());
    }

    // Add a list of words to a specific lesson
    public void addWordsToLesson(Lesson lesson, ArrayList<Word> words) {
        lessonWords.put(lesson, words);
    }

    // Get all translations in the dictionary (for all languages)
    public HashMap<Word, Word> getAllTranslations() {
        return fromEnglish;
    }

    // Add a new language to the list of available languages
    public void addLanguage(String language) {
        if (!languages.contains(language)) {
            languages.add(language);
        }
    }

    // Get the list of available languages
    public ArrayList<String> getAvailableLanguages() {
        return languages;
    }
}