import java.util.ArrayList;

public class PatternMatching {
    public ArrayList<Integer> naive(String text, String pattern) {
        // BigO((n-m+1)(m))
        int n = text.length();
        int m = pattern.length();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i <= n - m; i++) {
            for (int j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j))
                    break;
                if (m - 1 == j) {
                    res.add(i);
                }
            }
        }
        return res;
    }

    public ArrayList<Integer> improvedNaive(String text, String pattern) {
        // for distinct charecter in pattern O(n)
        ArrayList<Integer> res = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();
        for (int i = 0; i <= n - m;) {
            int j;
            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j))
                    break;
            }
            if (m == j) {
                res.add(i);
            }
            if (j == 0) {
                i++;
            } else {
                i = i + j;
            }
        }
        return res;
    }
}

class Solution {
    public static void main(String[] args) {
        PatternMatching pm = new PatternMatching();
        System.out.println(pm.improvedNaive("ABCABCD", "ABCD"));
    }
}