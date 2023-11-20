import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/
public class ValidParentheses {
    private boolean same(char b, char c) {
        return (b == '}' && c == '{') || (b == ')' && c == '(') || (b == ']' && c == '[');
    }

    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char b = s.charAt(i);
            if (b == '{' || b == '[' || b == '(') {
                stk.push(b);
            } else if (stk.isEmpty()) {
                return false;
            } else if (same(b, stk.peek())) {
                stk.pop();
            } else
                return false;
        }
        return stk.isEmpty();
    }
}
