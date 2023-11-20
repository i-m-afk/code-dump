import java.util.Stack;

public class BasicCalculator {

    private int precedence(char op) {
        switch (op) {
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return -1;
        }
    }

    private int applyOp(int a, int b, char opr) {
        switch (opr) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new UnsupportedOperationException("Cannot divide by zero!");
                }
                return a / b;
        }
        return 1;
    }

    public int calculate(String s) {
        s = s.trim(); // Trim leading and trailing spaces
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> optr = new Stack<>();
        String num = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num += c;
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                if (!num.isEmpty()) {
                    numbers.push(Integer.parseInt(num));
                    num = "";
                }
                if (c != ' ') {
                    while (!optr.empty() && precedence(c) <= precedence(optr.peek())) {
                        numbers.push(applyOp(numbers.pop(), numbers.pop(), optr.pop()));
                    }
                    optr.push(c);
                }
            }
        }
        if (!num.isEmpty()) {
            numbers.push(Integer.parseInt(num));
        }
        while (!optr.empty())
            numbers.push(applyOp(numbers.pop(), numbers.pop(), optr.pop()));

        return numbers.pop();
    }

    public static void main(String[] args) {
        BasicCalculator bs = new BasicCalculator();
        System.out.println(bs.calculate("2*32/32"));
    }
}
