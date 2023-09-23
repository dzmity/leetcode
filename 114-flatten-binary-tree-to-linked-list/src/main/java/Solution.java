class Solution {
    public void flatten(TreeNode root) {
        addRightBranchToLeftAndSwap(root);
    }

    private void addRightBranchToLeftAndSwap(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode rightBranch = root.right;
        TreeNode leftBranch = root.left;

        if (leftBranch != null) {
            findTheMostRightNode(leftBranch).right = rightBranch;
            root.right = root.left;
            root.left = null;
        }

        addRightBranchToLeftAndSwap(root.right);
    }

    private TreeNode findTheMostRightNode(TreeNode node) {
        TreeNode theMostRightNode = node;
        while (theMostRightNode.right != null) {
            theMostRightNode = theMostRightNode.right;
        }
        return theMostRightNode;
    }
}