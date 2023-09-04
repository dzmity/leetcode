public class Solution {
    public int removeElement(int[] nums, int val) {

        int additionalPointer = 0;

        for (int i = 0; i < nums.length; i++) {
            int element = nums[i];
            if (element != val) {
                nums[additionalPointer] = element;
                additionalPointer++;
            }
        }

        return additionalPointer;
    }
}