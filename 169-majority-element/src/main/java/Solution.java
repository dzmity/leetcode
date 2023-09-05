class Solution {
    /**
     * There are 3 possible solutions:
     * 1. Arrays.sort(nums) and getting element nums[nums.length / 2] (O(N*logN) time complexity)
     * 2. Use HashMap[Integer, Integer] (O(N) time complexity and O(N) space complexity)
     * 3. Use Boyer-Moore Majority Voting Algorithm (O(N) time complexity and O(1) space complexity)
     * https://www.geeksforgeeks.org/boyer-moore-majority-voting-algorithm/
     */
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
            }
            if (candidate == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}