import java.util.Stack;

class Solution {
    private static final char SLASH = '/';
    private static final char DOT = '.';

    public String simplifyPath(String path) {
        Stack<Character> stack = new Stack<>();

        for (char symbol : (path + SLASH).toCharArray()) {
            // Push any symbol if not slash
            if (stack.isEmpty() || symbol != SLASH) {
                stack.push(symbol);
                continue;
            }
            // Second slash case
            if (stack.peek() == SLASH) {
                continue;
            }
            // The next cases for / symbol
            if (stack.peek() == DOT) {
                char beforeDot = stack.elementAt(stack.size() - 2);
                if (beforeDot == SLASH) {
                    stack.pop();
                } else if (beforeDot == DOT) {
                    if (stack.elementAt(stack.size() - 3) == SLASH) {
                        toUpLevelDirectory(stack);
                    } else {
                        stack.push(symbol);
                    }
                } else {
                    stack.push(symbol);
                }
            } else {
                stack.push(symbol);
            }
        }

        if (stack.size() != 1 && stack.peek() == SLASH) {
            stack.pop();
        }

        StringBuilder builder = new StringBuilder();
        stack.forEach(builder::append);
        return builder.toString();
    }

    private void toUpLevelDirectory(Stack<Character> stack) {
        // drop 2 dots
        stack.pop();
        stack.pop();

        if (stack.size() == 1) {
            return;
        }

        stack.pop();
        while (stack.peek() != SLASH) {
            stack.pop();
        }
    }
}
