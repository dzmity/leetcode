import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;

public class Solution {

    // tree traversal - https://evileg.com/ru/post/490/
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        // prepare FIFO stack
        Stack<Integer> preorderQueue = new Stack<>();
        for (int postorderValue : postorder) {
            preorderQueue.push(postorderValue);
        }

        // prepare map with index by value
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return createNode(Optional.empty(), preorderQueue, inorderMap);
    }

    private TreeNode createNode(Optional<Integer> previousRightNode, Stack<Integer> preorder, Map<Integer, Integer> inorder) {
        if (preorder.isEmpty()) {
            return null;
        }

        Integer nodeValue = preorder.pop();
        TreeNode node = new TreeNode(nodeValue);

        if (!preorder.isEmpty()) {
            if (isRight(preorder.peek(), nodeValue, inorder)) {
                node.right = createNode(Optional.of(nodeValue), preorder, inorder);
            }
        }

        if (!preorder.isEmpty()) {
            if (previousRightNode.isEmpty() || isRight(preorder.peek(), previousRightNode.get(), inorder)) {
                node.left = createNode(previousRightNode, preorder, inorder);
            }
        }
        return node;
    }

    private boolean isRight(int valueToCheck, int currentValue, Map<Integer, Integer> inorder) {
        return inorder.get(valueToCheck) > inorder.get(currentValue);
    }
}
