import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == k) {
            return nums;
        }

        Map<Integer, Integer> countPerNumber = new HashMap<>();
        for (Integer number : nums) {
            countPerNumber.merge(number, 1, Integer::sum);
        }

        Comparator<Map.Entry<Integer, Integer>> fastComparator = (e1, e2) -> {
            int v1 = e1.getValue();
            int v2 = e2.getValue();
            return v2 - v1;
        };

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(fastComparator);
        queue.addAll(countPerNumber.entrySet());

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = queue.poll().getKey();
        }

        return result;
    }
}