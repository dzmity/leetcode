import java.util.ArrayList;
import java.util.List;

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inOrder = new ArrayList<>();
        inOrderTraversal(root, inOrder);
        return inOrder.get(k - 1);
    }

    private void inOrderTraversal(TreeNode node, List<Integer> accumulator) {
        if (node != null) {
            inOrderTraversal(node.left, accumulator);
            accumulator.add(node.val);
            inOrderTraversal(node.right, accumulator);
        }
    }
}