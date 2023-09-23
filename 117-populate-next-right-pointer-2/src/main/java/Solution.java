import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public Node connect(Node root) {
        if (root != null) {
            addRightLink(Collections.singletonList(root));
        }
        return root;
    }

    private void addRightLink(List<Node> nodes) {
        if (nodes.isEmpty()) {
            return;
        }
        List<Node> nextLevelNodes = new ArrayList<>();
        for (int i = 0; i <= nodes.size() - 1; i++) {
            Node node = nodes.get(i);

            if (i != nodes.size() - 1) {
                node.next = nodes.get(i + 1);
            }

            if (node.left != null) {
                nextLevelNodes.add(node.left);
            }

            if (node.right != null) {
                nextLevelNodes.add(node.right);
            }
        }

        addRightLink(nextLevelNodes);
    }
}