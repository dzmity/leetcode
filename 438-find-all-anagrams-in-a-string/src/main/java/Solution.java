import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    private static final char FIRST_LETTER = 'a';
    private static final int ALPHABET_SIZE = 26;

    // Todo: refactor me
    public void main(String[] args) {
        System.out.println(findAnagrams("abab", "ab"));
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("baa", "aa"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        int wordLength = p.length();
        if (s.length() < wordLength) {
            return Collections.emptyList();
        }

        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();
        int[] letters = generateNumberPerSymbolArray(pChars);
        List<Integer> indexes = new ArrayList<>();

        Pair pair = generateArray(sChars, 0, wordLength, letters);
        int[] previousLetters = pair.previousLetters;
        int startIndex = pair.startIndex;

        while (startIndex <= s.length() - wordLength) {
            char nextLetter = sChars[startIndex + wordLength - 1];
            while (letters[nextLetter - FIRST_LETTER] == 0) {
                startIndex = startIndex + wordLength;
                if (startIndex > s.length() - wordLength) {
                    return indexes;
                }
                pair = generateArray(sChars, startIndex, wordLength, letters);
                previousLetters = pair.previousLetters;
                startIndex = pair.startIndex;
                if (startIndex > s.length() - wordLength) {
                    return indexes;
                }
                nextLetter = sChars[startIndex + wordLength - 1];
            }

            previousLetters[nextLetter - FIRST_LETTER]++;
            if (Arrays.equals(previousLetters, letters)) {
                indexes.add(startIndex);
            }

            char letter = sChars[startIndex];
            previousLetters[letter - FIRST_LETTER]--;
            startIndex++;
        }
        return indexes;
    }

    private Pair generateArray(char[] sChars, int startIndex, int wordLength, int[] letters) {
        int[] previousLetters = new int[ALPHABET_SIZE];
        int endIndex = Math.min(sChars.length - 1, startIndex + wordLength - 1);
        for (int i = startIndex; i < endIndex; i++) {
            char letter = sChars[i];
            if (letters[letter - FIRST_LETTER] == 0) {
                previousLetters = new int[ALPHABET_SIZE];
                startIndex = i + 1;
                endIndex = Math.min(sChars.length - 1, startIndex + wordLength - 1);
                continue;
            }
            previousLetters[letter - FIRST_LETTER]++;
        }
        return new Pair(startIndex, previousLetters);
    }

    private int[] generateNumberPerSymbolArray(char[] pChars) {
        int[] letters = new int[ALPHABET_SIZE];
        for (char character : pChars) {
            letters[character - FIRST_LETTER]++;
        }
        return letters;
    }

    private class Pair {
        int startIndex;
        int[] previousLetters;

        public Pair(int startIndex, int[] previousLetters) {
            this.startIndex = startIndex;
            this.previousLetters = previousLetters;
        }
    }
}