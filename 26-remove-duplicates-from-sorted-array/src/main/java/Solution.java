class Solution {
    public int removeDuplicates(int[] nums) {

        int additionalPointer = 1;

        for (int i = 1; i < nums.length; i++) {
            int element = nums[i];
            int previousElement = nums[i - 1];
            if (element != previousElement) {
                nums[additionalPointer] = element;
                additionalPointer++;
            }
        }

        return additionalPointer;
    }
}