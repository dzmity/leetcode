import java.util.Arrays;

class Solution {

    // O(N) time complexity solution
    public boolean canJumpBestSolution(int[] nums) {
        int reachablePosition = 0;
        for (int position = 0; position < nums.length; position++) {
            if (reachablePosition < position) {
                return false;
            }
            reachablePosition = Math.max(reachablePosition, nums[position] + position);

            if (reachablePosition >= nums.length) {
                return true;
            }
        }
        return true;
    }

    // Dynamic Programming solution
    public boolean canJump(int[] nums) {
        boolean[] checkedFlags = new boolean[nums.length];
        return makeJump(0, nums, checkedFlags);
    }

    private boolean makeJump(int position, int[] nums, boolean[] checkedFlags) {
        if (checkedFlags[position]) {
            return false;
        }

        boolean reachTheEnd = false;
        int maxJumpLength = nums[position];
        int theEnd = nums.length - 1;

        if (position + maxJumpLength >= theEnd) {
            return true;
        }

        for (int jumpLength = maxJumpLength; jumpLength > 0; jumpLength--) {
            reachTheEnd = makeJump(position + jumpLength, nums, checkedFlags);
            if (reachTheEnd) {
                break;
            }
        }

        if (!reachTheEnd) {
            checkedFlags[position] = true;
        }
        return reachTheEnd;
    }
}
