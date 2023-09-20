import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // return dfs(root, 0);
        return bfs(1, Collections.singleton(root));
    }

    // Depth-First Search
    private int dfs(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }

        int leftDepth = dfs(root.left, depth + 1);
        int rightDepth = dfs(root.right, depth + 1);

        return Math.max(leftDepth, rightDepth);
    }

    // Breadth-First Search
    private int bfs(int depth, Set<TreeNode> nodes) {
        Set<TreeNode> nextLevelNodes = new HashSet<>();
        for (TreeNode node : nodes) {
            if (node.left != null) {
                nextLevelNodes.add(node.left);
            }
            if (node.right != null) {
                nextLevelNodes.add(node.right);
            }
        }

        if (nextLevelNodes.isEmpty()) {
            return depth;
        }
        return bfs(depth + 1, nextLevelNodes);
    }
}