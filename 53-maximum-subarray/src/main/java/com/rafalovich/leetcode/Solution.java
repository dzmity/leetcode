package com.rafalovich.leetcode;

public class Solution {

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int sumBefore = maxSum;
        int currentNumber;

        for (int i = 1; i < nums.length; i++) {
            currentNumber = nums[i];
            if (sumBefore < 0 || sumBefore + currentNumber < 0) {
                if (currentNumber > maxSum) {
                    maxSum = currentNumber;
                }
                sumBefore = currentNumber;
            } else {
                sumBefore += currentNumber;
                if (sumBefore > maxSum) {
                    maxSum = sumBefore;
                }
            }
        }
        return maxSum;
    }
}
