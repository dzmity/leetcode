class Solution {
    public int maxArea(int[] height) {
        int leftPointer = 0;
        int rightPointer = height.length - 1;
        int maxArea = calculateCurrentArea(height, leftPointer, rightPointer);

        while (leftPointer < rightPointer) {
            if (height[leftPointer] <= height[rightPointer]) {
                leftPointer++;
            } else {
                rightPointer--;
            }
            int currentArea = calculateCurrentArea(height, leftPointer, rightPointer);
            maxArea = Math.max(maxArea, currentArea);
        }
        return maxArea;
    }

    private int calculateCurrentArea(int[] height, int leftPointer, int rightPointer) {
        return Math.min(height[leftPointer], height[rightPointer]) * (rightPointer - leftPointer);
    }
}