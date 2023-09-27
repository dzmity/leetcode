import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root != null) {
            averageOfLevel(Collections.singleton(root), result);
        }
        return result;
    }

    private void averageOfLevel(Set<TreeNode> nodes, List<Double> accumulator) {
        Set<TreeNode> nextLevelNode = new HashSet<>();
        long sum = 0;
        int count = 0;
        for (TreeNode node : nodes) {
            sum += node.val;
            count++;
            if (node.right != null) nextLevelNode.add(node.right);
            if (node.left != null) nextLevelNode.add(node.left);
        }

        accumulator.add(((double) sum) / count);

        if (!nextLevelNode.isEmpty()) {
            averageOfLevel(nextLevelNode, accumulator);
        }
    }
}