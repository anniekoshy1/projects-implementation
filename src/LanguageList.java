import java.util.ArrayList;

public class LanguageList {

    private static LanguageList instance;
    private ArrayList<Language> languages;

    private LanguageList() {
        languages = new ArrayList<>();
    }

    public static LanguageList getInstance() {
        if (instance == null) {
            instance = new LanguageList();
        }
        return instance;
    }

    public Language addLanguage(Language language) {
        if (language != null && !languages.contains(language)) {
            languages.add(language);
            save(); 
            return language;
        }
        return null;
    }

    public ArrayList<Language> getLanguages() {
        return new ArrayList<>(languages);
    }

    public Language getLanguageByName(String name) {
        for (Language language : languages) {
            if (language.getName().equalsIgnoreCase(name)) {
                return language;
            }
        }
        return null; 
    }

    public boolean removeLanguage(Language language) {
        boolean removed = languages.remove(language);
        if (removed) {
            save(); 
        }
        return removed;
    }

    public void save() {
        DataWriter dataWriter = new DataWriter();
        dataWriter.saveLanguages(languages);
    }
}