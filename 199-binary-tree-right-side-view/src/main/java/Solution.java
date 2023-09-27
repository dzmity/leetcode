import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            bfs(Collections.singletonList(root), result);
        }
        return result;
    }

    private void bfs(List<TreeNode> nodes, List<Integer> accumulator) {
        List<TreeNode> nextLevelNodes = new ArrayList<>();
        accumulator.add(nodes.get(nodes.size() - 1).val);
        for (TreeNode node : nodes) {
            if (node.left != null) nextLevelNodes.add(node.left);
            if (node.right != null) nextLevelNodes.add(node.right);
        }

        if (!nextLevelNodes.isEmpty()) {
            bfs(nextLevelNodes, accumulator);
        }
    }
}