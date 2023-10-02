class Solution {
    public static final int NOT_FOUND_INDEX = -1;

    public int search(int[] nums, int target) {
        int startIndex = 0;
        int endIndex = nums.length - 1;

        if (nums[0] > nums[nums.length - 1]) {
            while (startIndex <= endIndex) {

                int middleIndex = (startIndex + endIndex) / 2;
                int startValue = nums[startIndex];
                int endValue = nums[endIndex];
                int middleValue = nums[middleIndex];

                if (target == middleValue) {
                    startIndex = middleIndex;
                    endIndex = middleIndex;
                    break;
                }

                if (startValue <= middleValue) {
                    if (startValue <= target && target < middleValue) {
                        endIndex = middleIndex - 1;
                        break;
                    }
                    startIndex = middleIndex + 1;
                } else {
                    if (middleValue < target && target <= endValue) {
                        startIndex = middleIndex + 1;
                        break;
                    }
                    endIndex = middleIndex - 1;
                }
            }
        }

        return binarySearch(startIndex, endIndex, nums, target);
    }

    private int binarySearch(int firstIndex, int lastIndex, int[] nums, int elementToSearch) {
        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (nums[middleIndex] == elementToSearch) {
                return middleIndex;
            }
            if (elementToSearch < nums[middleIndex]) {
                lastIndex = middleIndex - 1;
            } else {
                firstIndex = middleIndex + 1;
            }
        }
        return NOT_FOUND_INDEX;
    }
}