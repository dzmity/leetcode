import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> mapping = new HashMap<>();

        char[] sCharacters = s.toCharArray();
        char[] tCharacters = t.toCharArray();

        for (int i = 0; i < sCharacters.length; i++) {
            char sCharacter = sCharacters[i];
            char tCharacter = tCharacters[i];
            if(mapping.containsKey(sCharacter)) {
                if (mapping.get(sCharacter) != tCharacter) {
                    return false;
                }
            } else {
                mapping.put(sCharacter, tCharacter);
            }
        }

        return mapping.size() == new HashSet<>(mapping.values()).size();
    }
}
