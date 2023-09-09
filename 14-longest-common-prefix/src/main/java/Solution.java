import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public String longestCommonPrefix(String[] strs) {
        String shortestString = "";
        int shortestStringLength = Integer.MAX_VALUE;

        for (String str : strs) {
            if (str.length() < shortestStringLength) {
                shortestString = str;
                shortestStringLength = str.length();
            }
        }

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            if (!str.startsWith(shortestString)) {
                if (shortestString.length() == 1) {
                    return "";
                } else {
                    shortestString = shortestString.substring(0, shortestString.length() - 1);
                    i--;
                }
            }
        }

        return shortestString;
    }

    // provided solution is for the case:
    // "reflower","flow","flight" => "fl"
    public String longestCommonPrefixAnotherCase(String[] strs) {

        if (strs.length == 1) {
            return strs[0];
        }

        Map<String, Integer> prefixes = new HashMap<>();
        for (String str : strs) {
            for (int i = str.length(); i > 0; i--) {
                String subString = str.substring(0, i);
                int count = prefixes.getOrDefault(subString, 0);
                prefixes.put(subString, ++count);
            }
        }
        return prefixes.entrySet().stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .filter(entry -> entry.getValue() > 1)
                .orElseGet(() -> Map.entry("", 0))
                .getKey();
    }
}