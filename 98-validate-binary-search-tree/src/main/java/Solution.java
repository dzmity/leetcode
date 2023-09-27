class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode node, Integer minValue, Integer maxValue) {
        if (node == null) {
            return true;
        }

        int currentValue = node.val;

        return (minValue == null || currentValue > minValue)
                && (maxValue == null || currentValue < maxValue)
                && isValid(node.right, currentValue, maxValue)
                && isValid(node.left, minValue, currentValue);
    }
}