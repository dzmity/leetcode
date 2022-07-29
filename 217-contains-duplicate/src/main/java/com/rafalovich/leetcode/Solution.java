package com.rafalovich.leetcode;

import java.util.HashSet;

public class Solution {

    /**
     * O(n) time
     * O(n) space
     */
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int number : nums) {
            if (!set.add(number)) {
                return true;
            }
        }
        return false;
    }
}
