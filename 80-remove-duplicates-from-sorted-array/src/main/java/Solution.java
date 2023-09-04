class Solution {

    private static final int MAX_DUPLICATES_SIZE = 2;

    public int removeDuplicates(int[] nums) {

        if (nums.length <= MAX_DUPLICATES_SIZE) {
            return nums.length;
        }

        int additionalPointer = MAX_DUPLICATES_SIZE;
        int additionalPointerOriginalElement = nums[MAX_DUPLICATES_SIZE - 1];
        int skippedElementsSize = 0;

        for (int i = MAX_DUPLICATES_SIZE; i < nums.length; i++) {
            int element = nums[i];
            int previousElement = nums[i - 1];
            int elementBeforePrevious = nums[i - 2];

            if (element == previousElement
                    && element == elementBeforePrevious
                    && !(skippedElementsSize == 1 && additionalPointerOriginalElement != element)
            ) {
                skippedElementsSize++;
            } else {
                additionalPointerOriginalElement = nums[additionalPointer];
                nums[additionalPointer] = element;
                additionalPointer++;
            }
        }

        return additionalPointer;
    }
}