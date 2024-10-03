import java.util.ArrayList;
import java.util.HashMap;

public class MatchingQuestion extends Questions {

    // Attributes
    private ArrayList<String> leftItems;
    private ArrayList<String> rightItems;
    private HashMap<String, String> correctMatches;
    private HashMap<String, String> userMatches;

    // Constructor
    public MatchingQuestion(ArrayList<String> leftItems, ArrayList<String> rightItems, HashMap<String, String> correctMatches) {
        super("", "", 0);  // No question content or difficulty for now
        this.leftItems = leftItems;
        this.rightItems = rightItems;
        this.correctMatches = correctMatches;
        this.userMatches = new HashMap<>();
    }

    // Methods
    public void addPair(String key, String value) {
        userMatches.put(key, value);
    }

    public HashMap<String, String> getPairs() {
        return userMatches;
    }

    public void submitMatch(String leftItem, String rightItem) {
        addPair(leftItem, rightItem);
    }

    public void removePair(String key) {
        userMatches.remove(key);
    }

    public boolean checkAnswer() {
        return userMatches.equals(correctMatches);
    }
}
