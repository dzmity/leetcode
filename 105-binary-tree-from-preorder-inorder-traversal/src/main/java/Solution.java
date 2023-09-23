import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Solution {

    // tree traversal - https://evileg.com/ru/post/490/
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // prepare FIFO stack
        ArrayDeque<Integer> preorderQueue = new ArrayDeque<>();
        for (int preorderValue : preorder) {
            preorderQueue.add(preorderValue);
        }

        // prepare map with index by value
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return createNode(Optional.empty(), preorderQueue, inorderMap);
    }

    private TreeNode createNode(Optional<Integer> previousLeftNode, ArrayDeque<Integer> preorder, Map<Integer, Integer> inorder) {
        if (preorder.isEmpty()) {
            return null;
        }

        Integer nodeValue = preorder.pollFirst();
        TreeNode node = new TreeNode(nodeValue);

        if (!preorder.isEmpty()) {
            if (isLeft(preorder.peekFirst(), nodeValue, inorder)) {
                node.left = createNode(Optional.of(nodeValue), preorder, inorder);
            }
        }

        if (!preorder.isEmpty()) {
            if (previousLeftNode.isEmpty() || isLeft(preorder.peekFirst(), previousLeftNode.get(), inorder)) {
                node.right = createNode(previousLeftNode, preorder, inorder);
            }
        }
        return node;
    }

    private boolean isLeft(int valueToCheck, int currentValue, Map<Integer, Integer> inorder) {
        return inorder.get(valueToCheck) < inorder.get(currentValue);
    }
}
