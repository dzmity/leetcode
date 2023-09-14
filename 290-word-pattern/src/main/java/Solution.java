import java.util.HashMap;
import java.util.Map;

class Solution {

    public boolean wordPattern(String pattern, String t) {
        String[] words = t.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> mapping = new HashMap<>();
        Map<String, Character> reverseMapping = new HashMap<>();

        char[] patternCharacters = pattern.toCharArray();

        for (int i = 0; i < patternCharacters.length; i++) {
            char patternCharacter = patternCharacters[i];
            String word = words[i];

            String s = mapping.get(patternCharacter);
            Character c = reverseMapping.get(word);

            if (c == null && s == null) {
                mapping.put(patternCharacter, word);
                reverseMapping.put(word, patternCharacter);
                continue;
            }

            if (c == null || patternCharacter != c || !word.equals(s)) {
                return false;
            }
        }

        return true;
    }
}