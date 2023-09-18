import java.util.HashMap;
import java.util.Map;

class Solution2 {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> nodesByRoot = new HashMap<>();
        Map<Integer, Integer> lengthByNode = new HashMap<>();

        for (int num : nums) {
            nodesByRoot.put(num, num);
            lengthByNode.put(num, 1);
        }

        for (int num : nodesByRoot.keySet()) {
            if (nodesByRoot.containsKey(num - 1)) {
                int root = getRoot(num - 1, nodesByRoot);
                nodesByRoot.put(num, root);
                lengthByNode.merge(root, lengthByNode.get(num), Integer::sum);
            }
        }

        // expensive solution
       /*
        return length.values().stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
        */

        // cheap solution
        int maxLength = 0;
        for (int length: lengthByNode.values()) {
            if (length > maxLength) {
                maxLength = length;
            }
        }
        return maxLength;
    }

    private int getRoot(int num, Map<Integer, Integer> nodes) {
        Integer value = nodes.get(num);
        if (value == num) {
            return num;
        } else {
            return getRoot(value, nodes);
        }
    }
}
