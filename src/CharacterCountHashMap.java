import java.util.HashMap;
import java.util.Set;

/**
 * Created by qazimusab on 3/6/16.
 */
public class CharacterCountHashMap extends HashMap<Character, Integer> {

    private String originalString = "";

    public CharacterCountHashMap(String string) {
        super();
        if (string == null) {
            throw new NullPointerException();
        }

        originalString = string;
        organizeStringIntoHashMap(string);
    }

    private void organizeStringIntoHashMap(String string) {
        for (char c : string.toCharArray()) {
            if (containsKey(c)) {
                put(c, get(c) + 1);
            } else {
                put(c, 1);
            }
        }
    }

    public int getOccurrencesOf(char c) {
        if (!containsKey(c)) {
            return -1;
        } else {
            return get(c);
        }
    }

    public Set<Character> getAllCharacters() {
        return keySet();
    }

    public String getOriginalString() {
        return originalString;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(char c : getAllCharacters()) {
            stringBuilder
                    .append("Character: ")
                    .append(c)
                    .append("\t")
                    .append("Occurrences: ")
                    .append(getOccurrencesOf(c))
                    .append("\n");
        }
        return stringBuilder.toString();
    }
}
