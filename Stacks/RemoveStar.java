import java.util.Stack;

/*
 * Problem statement: https://leetcode.com/problems/removing-stars-from-a-string/
 */
public class RemoveStar {
    public String removeStars(String s) {
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '*' && !stk.isEmpty())
                stk.pop();
            else if (c != '*')
                stk.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }
}
