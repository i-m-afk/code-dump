

// My Question: Given a string of the format " k1(string1)k2(string2) " where the k1, k2... denote the number of times string1, string2... are repeated, return

// the final "unrolled" string.
// Example: 2(abc)3(de)
// Output: abcabcdedede

import java.util.regex.*;

public class Pattern1 {

    private static final String PATTERN = "(\\d+)\\((.*?)\\)";

    public static String unroll(String str) {
        Matcher matcher = Pattern.compile(PATTERN).matcher(str);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            int count = Integer.parseInt(matcher.group(1));
            String subStr = matcher.group(2);
            for (int i = 0; i < count; i++) {
                sb.append(subStr);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "2(abc)3(de)";
        System.out.println(unroll(str)); // abcabcdedede
    }
}
