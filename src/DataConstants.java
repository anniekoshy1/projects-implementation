import java.util.Arrays;
import java.util.List;

public abstract class DataConstants{
    public static final List<String> SUPPORTED_LANGUAGES = Arrays.asList("English", "Spanish", "French", "German");
    public static final String DEFAULT_LANGUAGE = "English";
    public static final int MIN_PASSWORD_LENGTH = 8;
    public static final int MAX_LOGIN_ATTEMPTS = 5;
    public static final int MAX_QUESTIONS_PER_QUIZ = 10;
    public static final int MAX_WORDS_PER_LESSON = 20;
    public static final int MIN_SCORE_PASS = 50;
    public static final List<String> DIFFICULTY_LEVELS = Arrays.asList("Rudimentary", "Intermediate", "Advanced");
    public static final int MAX_PASSWORD_LENGTH = 20;
    public static final String COURSE_LESSONS = "course_lessons";
    public static final String COURSE_NAME = "course_name";
    public static final String COURSE_DESCRIPTION = "course_description";
    public static final String USER_USERNAME = "user_username";
    public static final String USER_PASSWORD = "user_password";
    public static final String USER_EMAIL = "user_email";
    public static final String COURSE_ID = "course_id";
    public static final String LESSON_DESCRIPTION = "lesson_description";
    public static final String LESSON_ID = "lesson_id";
    public static final String ASSESSMENT_ID = "assessment_id";
    public static final int ASSESSMENT_SCORE = 100;
    public static final String LANGUAGE_NAME = "language_name";
    public static final String PHRASE_PART_OF_SPEECH = "phrase_part_of_speech";
    public static final String QUESTION_ID = "question_id";
    public static final String WORD_PART_OF_SPEECH = "word_part_of_speech";
    public static final String WORD_SYNONYM = "word_synonym";
    public static final String PHRASE_SYNONYM = "phrase_synonym";
    public static final String WORD_DEFINITION = "word_definition";
    public static final String PHRASE_DEFINITION = "phrase_definition";
    public static final int MAX_WORDS_PER_PHRASE = 5;
    public static final String DEFAULT_DIFFICULTY_LEVEL = "Rudimentary";
    public static final int MAX_HISTORICAL_FACTS_PER_LESSON = 10;
    public static final int MAX_USERS_IN_SYSTEM = 100000;
    public static final int MAX_LESSONS_PER_COURSE = 50;
}
