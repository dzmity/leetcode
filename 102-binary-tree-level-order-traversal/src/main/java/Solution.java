import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            bfs(Collections.singletonList(root), result);
        }
        return result;
    }

    private void bfs(List<TreeNode> nodes, List<List<Integer>> accumulator) {
        List<TreeNode> nextLevelNodes = new ArrayList<>();
        List<Integer> currentValues = new ArrayList<>();
        for (TreeNode node : nodes) {
            currentValues.add(node.val);
            if (node.left != null) nextLevelNodes.add(node.left);
            if (node.right != null) nextLevelNodes.add(node.right);
        }

        accumulator.add(currentValues);

        if (!nextLevelNodes.isEmpty()) {
            bfs(nextLevelNodes, accumulator);
        }
    }
}