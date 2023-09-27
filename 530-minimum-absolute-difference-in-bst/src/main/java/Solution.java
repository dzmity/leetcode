public class Solution {

    private static final int MIN_VALUE = -1_000_000_000;

    public int getMinimumDifference(TreeNode root) {
        return getMinDifference(root, MIN_VALUE, Integer.MAX_VALUE);
    }

    private int getMinDifference(TreeNode node, int min, int max) {
        int nodeValue = node.val;
        int diff = Math.min(nodeValue - min, max - nodeValue);
        if (diff == 1) return diff;

        if (node.right != null) {
            diff = Math.min(diff, getMinDifference(node.right, nodeValue, max));
        }
        if (diff == 1) return diff;

        if (node.left != null) {
            diff = Math.min(diff, getMinDifference(node.left, min, nodeValue));
        }
        return diff;
    }
}
