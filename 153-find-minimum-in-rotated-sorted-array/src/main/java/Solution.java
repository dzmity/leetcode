class Solution {

    public int findMin(int[] nums) {

        int leftPointer = 0;
        int rightPointer = nums.length - 1;
        if (nums[leftPointer] <= nums[rightPointer]) {
            return nums[leftPointer];
        }

        while (true) {
            int middlePointer = (leftPointer + rightPointer) / 2;
            int middleValue = nums[middlePointer];

            if (middleValue > nums[rightPointer]) {
                leftPointer = middlePointer + 1;
            } else {
                if (nums[middlePointer - 1] > middleValue) {
                    return middleValue;
                }
                rightPointer = middlePointer - 1;
            }
        }
    }
}