import java.util.ArrayList;

public class LanguageList {

    // Attributes
    private static LanguageList instance;
    private ArrayList<Language> languages;

    // Constructor
    private LanguageList() {
        languages = new ArrayList<>();
    }

    // Method to get the singleton instance
    public static LanguageList getInstance() {
        if (instance == null) {
            instance = new LanguageList();
        }
        return instance;
    }

    // Methods
    public Language addLanguage(Language language) {
        // No code for now
        return null;
    }

    public ArrayList<Language> getLanguages() {
        // No code for now
        return new ArrayList<>();
    }

    public Language getLanguageByName(String name) {
        // No code for now
        return null;
    }

    public boolean removeLanguage(Language language) {
        // No code for now
        return false;
    }

    public void save() {
        // No code for now
    }
}
