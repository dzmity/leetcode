import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public boolean isSymmetric(TreeNode root) {
        List<TreeNode> leftTree = Collections.singletonList(root.left);
        List<TreeNode> rightTree = Collections.singletonList(root.right);
        return isSymmetricBFS(leftTree, rightTree);
    }

    private boolean isSymmetricBFS(List<TreeNode> leftNodes, List<TreeNode> rightNodes) {
        List<Integer> leftValues = new ArrayList<>();
        for (int i = 0; i < leftNodes.size(); i++) {
            TreeNode node = leftNodes.get(i);
            if (node == null) {
                leftValues.add(null);
            } else {
                leftValues.add(node.val);
            }
        }

        List<Integer> rightValues = new ArrayList<>();
        for (int i = rightNodes.size() - 1; i >= 0; i--) {
            TreeNode node = rightNodes.get(i);
            if (node == null) {
                rightValues.add(null);
            } else {
                rightValues.add(node.val);
            }
        }

        if (!rightValues.equals(leftValues)) {
            return false;
        }

        List<TreeNode> nextLevelLeftNodes = new ArrayList<>();
        List<TreeNode> nextLevelRightNodes = new ArrayList<>();

        for (int i = 0; i < leftNodes.size(); i++) {
            TreeNode leftNode = leftNodes.get(i);
            if (leftNode != null) {
                nextLevelLeftNodes.add(leftNode.left);
                nextLevelLeftNodes.add(leftNode.right);
            }

            TreeNode rightNode = rightNodes.get(i);
            if (rightNode != null) {
                nextLevelRightNodes.add(rightNode.left);
                nextLevelRightNodes.add(rightNode.right);
            }
        }

        if (nextLevelLeftNodes.isEmpty() && nextLevelRightNodes.isEmpty()) {
            return true;
        }
        return isSymmetricBFS(nextLevelLeftNodes, nextLevelRightNodes);
    }
}