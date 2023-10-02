class Solution {

    // JFYI: x ^ x = 0
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int number : nums) {
            result ^= number;
        }
        return result;
    }
}