import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        List<Integer> result = findAnagrams("cbaebabacd", "abc");
        System.out.println(result);
    }

    public static List<Integer> findAnagrams(String s, String p) {

        if (s.length() < p.length()) {
            return Collections.emptyList();
        }

        char[] pChars = p.toCharArray();
        Map<Character, Integer> characterIntegerMap = generateNumberPerSymbolMap(pChars);

        List<Integer> indexes = new ArrayList<>();
        char[] sChars = s.toCharArray();

        // map with word.length() - 1 symbols
        Map<Character, Integer> previousSymbols = new HashMap<>();
        for (int i = 0; i < p.length() - 1; i++) {
            char symbol = sChars[i];
            previousSymbols.merge(symbol, 1, Integer::sum);
        }

        int startIndex = 0;
        while (startIndex <= s.length() - p.length()) {
            previousSymbols.merge(sChars[startIndex + p.length() - 1], 1, Integer::sum);
            if (previousSymbols.equals(characterIntegerMap)) {
                indexes.add(startIndex);
            }
            char symbol = sChars[startIndex];
            int symbolsNumber = previousSymbols.get(symbol);
            if (symbolsNumber == 1) {
                previousSymbols.remove(symbol);
            } else {
                previousSymbols.put(symbol, symbolsNumber - 1);
            }
            startIndex++;
        }
        return indexes;
    }

    private static Map<Character, Integer> generateNumberPerSymbolMap(char[] pChars) {
        Map<Character, Integer> map = new HashMap<>();
        for (char character : pChars) {
            map.merge(character, 1, Integer::sum);
        }
        return map;
    }
}