package com.rafalovich.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> ransomNoteMap = new HashMap<>();
        HashMap<Character, Integer> magazineMap = new HashMap<>();

        for (Character ch : ransomNote.toCharArray()) {
            ransomNoteMap.merge(ch, 1, Integer::sum);
        }

        for (Character ch : magazine.toCharArray()) {
            magazineMap.merge(ch, 1, Integer::sum);
        }

        for (Map.Entry<Character, Integer> entry : ransomNoteMap.entrySet()) {
            int quantity = entry.getValue();
            char letter = entry.getKey();
            if (!magazineMap.containsKey(letter) || magazineMap.get(letter) < quantity) {
                return false;
            }
        }
        return true;
    }
}
