import java.util.HashMap;
import java.util.Map;

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Integer, Node> nodePerValue = new HashMap<>();
        return dfs(node, nodePerValue);
    }

    private Node dfs(Node node, Map<Integer, Node> nodePerValue) {
        Node copy;
        if (!nodePerValue.containsKey(node.val)) {
            copy = new Node(node.val);
            nodePerValue.put(node.val, copy);
            for (Node neighbor : node.neighbors) {
                copy.neighbors.add(dfs(neighbor, nodePerValue));
            }
        } else {
            copy = nodePerValue.get(node.val);
        }
        return copy;
    }
}