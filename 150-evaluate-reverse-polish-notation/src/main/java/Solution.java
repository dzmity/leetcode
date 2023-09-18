import java.util.Stack;

class Solution {
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLICATION = "*";
    private static final String DIVISION = "/";

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals(PLUS)) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals(MINUS)) {
                Integer first = stack.pop();
                Integer second = stack.pop();
                stack.push(second - first);
            } else if (token.equals(MULTIPLICATION)) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals(DIVISION)) {
                Integer first = stack.pop();
                Integer second = stack.pop();
                stack.push(second / first);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}