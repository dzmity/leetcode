class Solution {

    public boolean isBalanced(TreeNode root) {
        return dfsLength(root).balanced;
    }

    private static BalanceResult dfsLength(TreeNode node) {
        if (node == null) {
            return new BalanceResult(0, true);
        }

        BalanceResult leftBranchResult = dfsLength(node.left);
        if (!leftBranchResult.balanced) {
            return leftBranchResult;
        }

        BalanceResult rightBranchResult = dfsLength(node.right);
        if (!rightBranchResult.balanced) {
            return rightBranchResult;
        }

        if (Math.abs(leftBranchResult.length - rightBranchResult.length) > 1) {
            return new BalanceResult(0, false);
        }

        int subTreeMaxLength = Math.max(leftBranchResult.length, rightBranchResult.length) + 1;
        return new BalanceResult(subTreeMaxLength, true);
    }

    private static class BalanceResult {
        int length;
        boolean balanced;

        public BalanceResult(int length, boolean balanced) {
            this.length = length;
            this.balanced = balanced;
        }
    }
}
