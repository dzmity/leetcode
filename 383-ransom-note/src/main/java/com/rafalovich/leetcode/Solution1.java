package com.rafalovich.leetcode;

public class Solution1 {

    private static final int ALPHABET_SIZE = 26;
    private static final char FIRST_LETTER = 'a';

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] letters = new int[ALPHABET_SIZE];

        for (Character letter : magazine.toCharArray()) {
            letters[letter - FIRST_LETTER]++;
        }

        for (Character letter : ransomNote.toCharArray()) {
            if (--letters[letter - FIRST_LETTER] < 0) {
                return false;
            }
        }
        return true;
    }
}
