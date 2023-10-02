public class LCS {
    // practice.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/
    private static int solve(int idx1, int idx2, String s1, String s2) {
        // base case
        if (idx1 < 0 || idx2 < 0)
            return 0;
        // match
        if (s1.charAt(idx1) == s2.charAt(idx2)) {
            return 1 + solve(idx1 - 1, idx2 - 2, s1, s2);
        }
        return Math.max(solve(idx1 - 1, idx2, s1, s2), solve(idx1, idx2 - 1, s1, s2));
    }

    // Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String str1, String str2) {
        return solve(x - 1, y - 1, str1, str2);
    }

}
