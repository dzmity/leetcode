package com.rafalovich.leetcode;

public class ExtendedSolution {

    public static void main(String[] args) {
        maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4, -10, -8, 4, -2, 3, 1, 0, -1, 2});
    }

    public static int maxSubArray(int[] nums) {
        int startPosition = 0;
        int endPosition = 0;
        int maxSum = nums[0];
        int sumBefore = maxSum;
        int potentialStartPosition = 0;
        int currentNumber;

        for (int i = 1; i < nums.length; i++) {
            currentNumber = nums[i];
            if (sumBefore < 0 || sumBefore + currentNumber < 0) {
                if (currentNumber > maxSum) {
                    startPosition = i;
                    endPosition = i;
                    maxSum = currentNumber;
                }
                sumBefore = currentNumber;
                potentialStartPosition = i;

            } else {
                sumBefore += currentNumber;
                if (sumBefore > maxSum) {
                    maxSum = sumBefore;
                    startPosition = potentialStartPosition;
                    endPosition = i;
                }
            }
        }

        printSubArray(nums, startPosition, endPosition, maxSum);
        return maxSum;
    }

    private static void printSubArray(int[] nums, int startPosition, int endPosition, int maxSum) {
        System.out.println("Max sum: " + maxSum);
        System.out.print("Related subArray: ");
        for (int i = startPosition; i <= endPosition; i++) {
            System.out.print(nums[i]);
            if (i != endPosition) {
                System.out.print(",");
            }
        }
    }
}
