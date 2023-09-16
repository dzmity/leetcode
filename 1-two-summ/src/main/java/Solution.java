import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> values = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!values.containsKey(target - nums[i])) {
                values.put(nums[i], i);
            } else {
                return new int[] {values.get(target - nums[i]), i};
            }
        }
        return new int[]{};
    }
}