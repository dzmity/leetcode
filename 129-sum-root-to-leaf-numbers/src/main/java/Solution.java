import java.util.Arrays;

class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, new int[]{root.val});
    }

    private int dfs(TreeNode node, int[] previous) {
        TreeNode left = node.left;
        TreeNode right = node.right;

        int sum = 0;

        if (left != null) {
            int[] newArray = Arrays.copyOf(previous, previous.length + 1);
            newArray[previous.length] = left.val;
            sum += dfs(left, newArray);
        }
        if (right != null) {
            int[] newArray = Arrays.copyOf(previous, previous.length + 1);
            newArray[previous.length] = right.val;
            sum += dfs(right, newArray);
        }

        if (left == null && right == null) {
            sum = calculateValue(previous);
        }

        return sum;
    }

    private int calculateValue(int[] values) {
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i] * (int) Math.pow(10, values.length - 1 - i);
        }
        return sum;
    }
}