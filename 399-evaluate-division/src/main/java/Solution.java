import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public double[] calcEquation(
            List<List<String>> equations,
            double[] values,
            List<List<String>> queries) {

        Map<String, Node> linkPerSymbol = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String firstVariable = equation.get(0);
            String secondVariable = equation.get(1);
            double value = values[i];

            boolean containsFirsVariable = linkPerSymbol.containsKey(firstVariable);
            boolean containsSecondVariable = linkPerSymbol.containsKey(secondVariable);
            if (!containsFirsVariable && !containsSecondVariable) {
                linkPerSymbol.put(firstVariable, new Node(value, secondVariable));
                linkPerSymbol.put(secondVariable, new Node(1, secondVariable));
            } else if (!containsFirsVariable) {
                linkPerSymbol.put(firstVariable, new Node(value, secondVariable));
            } else if (!containsSecondVariable) {
                linkPerSymbol.put(secondVariable, new Node(1 / value, firstVariable));
            } else {
                Node firstRoot = findRoot(firstVariable, linkPerSymbol, 1);
                Node secondRoot = findRoot(secondVariable, linkPerSymbol, 1);
                linkPerSymbol.put(firstRoot.variable, new Node(value * secondRoot.val / firstRoot.val, secondRoot.variable));
            }
        }

        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String firstVariable = query.get(0);
            String secondVariable = query.get(1);

            // case for x / x if we don't have any information of x
            // should return -1 according to the task
            if (!linkPerSymbol.containsKey(firstVariable) || !linkPerSymbol.containsKey(secondVariable)) {
                result[i] = -1;
                continue;
            }

            if (firstVariable.equals(secondVariable)) {
                result[i] = 1;
                continue;
            }

            Node first = findRoot(firstVariable, linkPerSymbol, 1);
            Node second = findRoot(secondVariable, linkPerSymbol, 1);

            if (!first.variable.equals(second.variable)) {
                result[i] = -1;
                continue;
            }

            result[i] = first.val / second.val;
        }

        return result;
    }

    private Node findRoot(String variable, Map<String, Node> linkPerSymbol, double multiplier) {
        Node root = linkPerSymbol.get(variable);
        if (root.variable.equals(variable)) {
            return new Node(multiplier * root.val, variable);
        }
        return findRoot(root.variable, linkPerSymbol, multiplier * root.val);
    }

    private class Node {
        double val;
        String variable;

        public Node(double val, String variable) {
            this.val = val;
            this.variable = variable;
        }
    }
}