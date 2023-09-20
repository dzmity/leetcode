import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> pList = new ArrayList<>();
        List<Integer> qList = new ArrayList<>();

        populateArrayBFS(Collections.singletonList(p), pList);
        populateArrayBFS(Collections.singletonList(q), qList);
        return pList.equals(qList);
    }

    private void populateArrayBFS(List<TreeNode> nodes, List<Integer> aggregator) {
        List<TreeNode> nextLevelNodes = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (node == null) {
                aggregator.add(null);
            } else {
                aggregator.add(node.val);
                nextLevelNodes.add(node.left);
                nextLevelNodes.add(node.right);
            }
        }
        if (nextLevelNodes.isEmpty()) {
            return;
        }
        populateArrayBFS(nextLevelNodes, aggregator);
    }
}