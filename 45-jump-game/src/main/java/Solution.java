class Solution {

    private static final int INFINITIVE_JUMPS_NUMBER = Integer.MAX_VALUE;

    // O(N^2) time complexity solution

    // In the range [jumpStart = 0, jumpMaxPosition = nums[0]] (every position could be reached in 1 jump)
    // try to find nextJumpMaxPosition - max destination for the next jump.
    // When position > jumpMaxPosition it means we need additional jump to reach it.
    // And by this jump we can reach any position from [previousJumpMaxPosition + 1, nextJumpMaxPosition]
    // Cycle is continuing.
    public int jumpBestSolution(int[] nums) {

        if (nums.length == 1) {
            return 0;
        }

        int jumpNumber = 0;
        int currentJumpMaxPosition = 0;
        int nextJumpMaxPosition = 0;

        for (int position = 0; position < nums.length; position++) {
            nextJumpMaxPosition = Math.max(nextJumpMaxPosition, position + nums[position]);

            if (nextJumpMaxPosition >= nums.length - 1){
                jumpNumber++;
                break;
            }

            if (position == currentJumpMaxPosition) {
                jumpNumber++;
                currentJumpMaxPosition = nextJumpMaxPosition;
            }
        }

        return jumpNumber;
    }

    // O(N^2) time complexity solution
    public int jump(int[] nums) {
        int[] jumpsNumberFrom = new int[nums.length];
        for (int i = nums.length - 2; i >= 0; i--) {
            jumpsNumberFrom[i] = min(jumpsNumberFrom, i, nums[i]);
        }
        return jumpsNumberFrom[0];
    }

    private int min(int[] jumpsNumberFrom, int position, int maxJumpLength) {
        if (maxJumpLength == 0) {
            return INFINITIVE_JUMPS_NUMBER;
        }

        int maxReachablePosition = Math.min(position + maxJumpLength, jumpsNumberFrom.length - 1);

        int minJumpsNumber = INFINITIVE_JUMPS_NUMBER - 1;
        for (int i = position + 1; i <= maxReachablePosition; i++) {
            minJumpsNumber = Math.min(minJumpsNumber, jumpsNumberFrom[i]);
        }
        return minJumpsNumber + 1;
    }
}
