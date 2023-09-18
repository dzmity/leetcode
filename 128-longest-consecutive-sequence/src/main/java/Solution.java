import java.util.Arrays;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int consecutiveSequenceLength = 1;
        int currentLength = 1;
        int previousValue = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num == previousValue + 1) {
                currentLength++;
                if (currentLength > consecutiveSequenceLength) {
                    consecutiveSequenceLength = currentLength;
                }
            } else if (num == previousValue) {
                continue;
            } else {
                currentLength = 1;
            }

            previousValue = num;
        }
        return consecutiveSequenceLength;
    }
}
