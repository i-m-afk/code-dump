package Memoisation;

import java.util.Arrays;

public class LCS {
    private static int solve(int idx1, int idx2, String s1, String s2, int[][] dp) {
        // Base case
        if (idx1 == 0 || idx2 == 0)
            return 0;
        if (dp[idx1][idx2] != -1)
            return dp[idx1][idx2];
        // Match
        if (s1.charAt(idx1 - 1) == s2.charAt(idx2 - 1)) {
            return dp[idx1][idx2] = 1 + solve(idx1 - 1, idx2 - 1, s1, s2, dp);
        }
        return dp[idx1][idx2] = Math.max(solve(idx1 - 1, idx2, s1, s2, dp),
                solve(idx1, idx2 - 1, s1, s2, dp));
    }

    // Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String str1, String str2) {
        int[][] dp = new int[x + 1][y + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return solve(x, y, str1, str2, dp);
    }

}
