import java.util.Arrays;
import java.util.List;

public class DataConstants {

    // Constants for user information
    public static final int MIN_PASSWORD_LENGTH = 8;  // Minimum length for passwords
    public static final int MAX_PASSWORD_LENGTH = 16;  // Maximum length for passwords
    public static final int MAX_LOGIN_ATTEMPTS = 5;  // Maximum login attempts before account lock
    public static final String USER_USERNAME = "username";  
    public static final String USER_PASSWORD = "password";  
    public static final String USER_EMAIL = "email";  

    // Constants for courses
    public static final int MAX_LESSONS_PER_COURSE = 20;  // Maximum lessons allowed per course
    public static final int MAX_USERS_IN_SYSTEM = 100000;  // Maximum number of users in the system
    public static final String COURSE_NAME = "courseName";  
    public static final String COURSE_DESCRIPTION = "courseDescription";  
    public static final String COURSE_ID = "courseID";  
    public static final String COURSE_LESSONS = "courseLessons";  

    // Constants for lessons
    public static final String LESSON_DESCRIPTION = "lessonDescription";  
    public static final String LESSON_ID = "lessonID";  
    public static final int MAX_WORDS_PER_LESSON = 50;  // Maximum number of words allowed per lesson
    public static final int MAX_HISTORICAL_FACTS_PER_LESSON = 10;  // Maximum number of historical facts per lesson

    // Constants for assessments
    public static final String ASSESSMENT_ID = "assessmentID";  
    public static final int ASSESSMENT_SCORE = 60;  // Default pass score for assessments (60%)
    public static final int MAX_QUESTIONS_PER_QUIZ = 10;  // Maximum number of questions per quiz

    // Constants for languages
    public static final String LANGUAGE_NAME = "languageName";  
    public static final String DEFAULT_LANGUAGE = "English";  // Default language for the system
    public static final List<String> SUPPORTED_LANGUAGES = Arrays.asList("English", "Spanish", "French", "German", "Mandarin");

    // Constants for phrases
    public static final String PHRASE_PART_OF_SPEECH = "partOfSpeech";  
    public static final String PHRASE_DEFINITION = "phraseDefinition";  
    public static final String PHRASE_SYNONYM = "phraseSynonym";  

    // Constants for words
    public static final String WORD_PART_OF_SPEECH = "wordPartOfSpeech"; 
    public static final String WORD_SYNONYM = "wordSynonym"; 
    public static final String WORD_DEFINITION = "wordDefinition"; 

    // Constants for difficulty levels
    public static final List<String> DIFFICULTY_LEVELS = Arrays.asList("Rudimentary", "Intermediate", "Advanced");
    public static final String DEFAULT_DIFFICULTY_LEVEL = "Rudimentary";  // Default difficulty level

    // Constants for phrase and word limits
    public static final int MAX_WORDS_PER_PHRASE = 5;  // Maximum words allowed per phrase
    public static final int MIN_SCORE_PASS = 60;  // Minimum score to pass a quiz or assessment
}