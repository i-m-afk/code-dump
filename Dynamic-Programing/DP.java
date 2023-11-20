import java.util.Arrays;

public class DP {
    /**
     * optimisation over plain recursion
     * Idea is to reuse the solutions of overlapping sub problems
     * 1) Memo (Top Down)
     * 2) Tabulation (Bottom Up)
     */

    // Longest Common Subsequence
    public static void main(String[] args) {
        /*
         * LCS obj = new LCS();
         * System.out.println(obj.longestCommonSub("AGGTAB",
         * "GXTXAYB", 6, 7));
         * 
         * CoinChange obj = new CoinChange();
         * int[] coins = { 2, 5, 3, 6 };
         * obj.test();
         * 
         * EditDistance obj = new EditDistance();
         * System.out.println(obj.eD("sunday", "saturday"));
         * LIS obj = new LIS();
         * int[] arr = { 3, 10, 2, 1, 20 };
         * System.out.println(obj.lis(arr));
         * int[] arr = { 1, 11, 2, 10, 4, 5, 2, 1 }; // 6
         * LIS obj = new LIS();
         * System.out.println(obj.longestBitonicSubsequence(arr));
         * LIS obj = new LIS();
         * int[][] bridges = { { 6, 2 }, { 4, 3 }, { 2, 6 }, { 1, 5 } };
         * System.out.println(obj.buildingBridges(bridges));
         * LIS obj = new LIS();
         * int[][] pairs = { { 5, 24 }, { 15, 25 }, { 27, 40 }, { 50, 60 } }; // 3
         * System.out.println(obj.longestChainPairs(pairs));
         * int maxCuts = new MaximumCuts().maxCutsDp(23, 11, 9, 12); // 2
         * System.out.println(maxCuts);
         * MinimumCoins obj = new MinimumCoins();
         * int[] coins = { 9, 6, 5, 1 };
         * int value = 11;
         * System.out.println(obj.coins(coins, value)); // 2
         */

        MinimumJump obj = new MinimumJump();
        int[] arr = { 3, 4, 2, 1, 2, 1 };
        System.out.println(obj.minReach(arr)); // 2
    }
}

class MinimumJump {
    public int minReach(int[] arr, int i){
    
        
    }
}

class MinimumCoins {
    private int solve(int[] coins, int value, int idx) {
        if (idx >= coins.length)
            return Integer.MAX_VALUE - 1;
        if (value < 0)
            return Integer.MAX_VALUE - 1;
        if (value == 0)
            return 0;
        int include = 1 + solve(coins, value - coins[idx], idx);
        int notInclude = solve(coins, value, idx + 1);
        return Math.min(include, notInclude);
    }

    public int coins(int[] coins, int value) {
        return solve(coins, value, 0);
    }

}

class MaximumCuts {
    // Time complexity : O(3^n)
    public int maxCuts(int n, int a, int b, int c) {
        if (n < 0)
            return -1;
        if (n == 0)
            return 0;
        int res = Math.max(maxCuts(n - a, a, b, c),
                Math.max(maxCuts(n - b, a, b, c), maxCuts(n - c, a, b, c)));
        return res == -1 ? res : res + 1;
    }

    // Time complexity : O(n)
    // Space complexity : O(n)
    public int maxCutsDp(int n, int a, int b, int c) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = -1;
            if (i - a >= 0) {
                dp[i] = Math.max(dp[i], dp[i - a]);
            }
            if (i - b >= 0) {
                dp[i] = Math.max(dp[i], dp[i - b]);
            }
            if (i - c >= 0) {
                dp[i] = Math.max(dp[i], dp[i - c]);
            }
            if (dp[i] != -1)
                dp[i]++;
        }
        return dp[n];

    }
}

class LCS {
    int m, n;
    int[][] memo;

    private int solve(String s1, String s2, int i, int j) {
        if (i <= 0 || j <= 0)
            return 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            return 1 + solve(s1, s2, i - 1, j - 1);
        }
        return Math.max(solve(s1, s2, i - 1, j), solve(s1, s2, i, j - 1));
    }

    private int solveMemo(String s1, String s2, int i, int j) {
        if (i <= 0 || j <= 0)
            return 0;
        if (memo[i][j] != -1)
            return memo[i][j];
        if (s1.charAt(i) == s2.charAt(j))
            return memo[i][j] = 1 + solve(s1, s2, i - 1, j - 1);
        return memo[i][j] = Math.max(solveMemo(s1, s2, i - 1, j), solveMemo(s1, s2, i, j - 1));
    }

    // Time complexity Theta(m*n)
    private int solveDp(String s1, String s2) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public int longestCommonSub(String s1, String s2, int m, int n) {
        /*
         * "ABCDGH"
         * AEDFHR
         */
        this.m = m;
        this.n = n;

        return solveDp(s1, s2);
    }

    /**
     * Variations of LCS
     * 1) Longest Common Substring
     * 2) Shortest Common Supersequence
     * 3) Minimum number of insertions and deletions to convert string a to b
     * 4) Longest Palindromic Subsequence
     * 5) Minimum number of deletions to make a string palindrome
     * 6) Print Shortest Common Supersequence
     * 7) Print Longest Palindromic Subsequence
     * 8) Sequence Pattern Matching
     * 9) Minimum number of insertion to make a string palindrome
     * 10) Longest Repeating Subsequence
     * 11) Subsequence Pattern Matching
     * 12) Longest Bitonic Subsequence
     * 13) Longest Increasing Subsequence
     * 14) Maximum Sum Increasing Subsequence
     * 15) Minimum number of deletion to make a sorted sequence
     * 16) Longest Alternating Subsequence
     * 17) Partition a set into two subsets such that the difference of subset sums
     * is minimum
     * 18) Count number of ways to partition a set into k subsets
     * 19) Count all subsequences having product less than K
     * 20) Count of subsequences of length n having palindromic first and last
     * characters
     * 
     */

}

class CoinChange {
    int[][] memo;

    private int solve(int[] coins, int sum, int idx) {
        if (sum < 0)
            return 0;
        if (sum == 0) {
            return 1;
        }
        int totalCount = 0;
        for (int i = idx; i < coins.length; i++) {
            totalCount += solve(coins, sum - coins[i], i);
        }
        return totalCount;
    }

    private int getCount(int[] coins, int n, int sum) {
        if (sum < 0)
            return 0;
        if (sum == 0) // don't pick any coin
            return 1;
        if (n == 0) // but sum > 0 (that is we cant pick a coin because there is none)
            return 0;
        if (memo[n][sum] != -1)
            return memo[n][sum];

        int res = getCount(coins, n - 1, sum); // include
        if (coins[n - 1] <= sum) {
            res += getCount(coins, n, sum - coins[n - 1]); // not include last coin
        }
        return memo[n][sum] = res;
    }

    private int getCount(int[] coins, int sum) {
        int n = coins.length;
        int[][] dp = new int[sum + 1][n + 1]; // dp[i][j] : no. of combinations we can get with sum i and coins form
                                              // i
                                              // to j

        for (int col = 0; col <= n; col++) {
            dp[0][col] = 1;
        }
        for (int row = 1; row <= sum; row++) {
            dp[row][0] = 0;
        }

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1]; // not include last coin
                if (coins[j - 1] <= i) {
                    dp[i][j] += dp[i - coins[j - 1]][j]; // include last coin
                }
            }
        }
        return dp[sum][n];
    }

    public int allPossibleCoins(int[] coins, int sum) {
        // return solve(coins, sum, 0);
        // memo = new int[coins.length + 1][sum + 1];
        // for (int i[] : memo) {
        // Arrays.fill(i, -1);
        // }
        return getCount(coins, sum);
    }

    // testing
    private int[] generatorCoins(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) Math.ceil(Math.random() * 10);
        }
        return arr;
    }

    private int generatorSum(int n) {
        return (int) Math.ceil(Math.random() * 100);
    }

    public boolean test() {
        while (true) {
            int[] coins = generatorCoins(10);
            int sum = generatorSum(100);
            if (solve(coins, sum, 0) != getCount(coins, sum))
                System.out.println("Error");
            else
                System.out.println("OK");
        }
    }
}

class EditDistance {
    // This can be used in spell checker, DNA sequencing, etc
    // Time complexity : O(3^m)
    public int eD(String s1, String s2, int m, int n) {

        if (m == 0) // if s2 is empty then we have to insert all the characters of s1
            return n;
        if (n == 0) // if s1 is empty then we have to insert all the characters of s2
            return m;

        // if last characters are same then we don't have to do any operation
        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return eD(s1, s2, m - 1, n - 1);

        // if last characters are not same then we have to do one of the following1
        int insert = eD(s1, s2, m, n - 1);
        int replace = eD(s1, s2, m - 1, n - 1);
        int delete = eD(s1, s2, m - 1, n);

        return 1 + Math.min(replace, Math.min(insert, delete)); // doing 1 operation
    }

    // Time complexity : O(m*n)
    // Space complexity : O(m*n)
    public int eDdp(String s1, String s2, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int rows = 0; rows <= m; rows++) {
            dp[rows][0] = rows;
        }
        for (int cols = 0; cols <= n; cols++) {
            dp[0][cols] = cols;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
            }
        }
        return dp[m][n];
    }

    public int eD(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        return eDdp(s1, s2, m, n);
    }

}

class LIS {
    // arr[] = { 3, 10, 2, 1, 20 }
    // LIS = 3, 10, 20
    // Time complexity : O(2^n)
    public int lis(int[] arr) {
        return lengthOfLIS(arr);
    }

    // Time complexity : O(2^n)
    // Space complexity : O(n)
    private int solveLis(int[] arr, int n) {
        if (n == 1)
            return 1;
        int res, max = 1;
        for (int i = 1; i < n; i++) {
            res = solveLis(arr, i);
            if (arr[i - 1] < arr[n - 1] && res + 1 > max) {
                max = res + 1;
            }
        }
        return max;
    }

    // Time complexity : O(n^2)
    // Space complexity : O(n)
    private int solveLisDp(int arr[]) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = 1;

        int max = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // Time complexity : O(nlogn)
    public int lengthOfLIS(int[] arr) {
        // tail[i] : smallest tail of all increasing subsequences of length i+1
        // tips: tail array is sorted in increasing order, so we can use binary search
        // to find the ceil element
        // ceil element : smallest element greater than target element in sorted array
        // { 2, 3, 6, 7, 8, 10, 12, 14, 16, 18 }
        // target = 9
        // ceil = 10
        // index = 5
        // tail[5] = 9

        int n = arr.length;
        int[] tail = new int[n];

        tail[0] = arr[0];
        int len = 1;

        for (int i = 1; i < n; i++) {
            // if arr[i] is greater than last element of tail array then we have to append
            // it to tail array
            if (arr[i] > tail[len - 1]) {
                tail[len] = arr[i];
                len++;
            }
            // if arr[i] is smaller than last element of tail array then we have to update
            // the tail array
            else {
                int index = binarySearch(tail, 0, len - 1, arr[i]);
                tail[index] = arr[i];
            }
        }
        return len;
    }

    // returns index of ceil element
    private int binarySearch(int[] arr, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target == arr[mid]) {
                return mid;
            }
            if (target < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    /**
     * Variations of LIS
     * 1) Longest Increasing Subsequence
     * 2) Maximum Sum Increasing Subsequence
     * 3) Minimum number of deletion to make a sorted sequence
     * 4) Longest Alternating Subsequence
     * 5) Partition a set into two subsets such that the difference of subset sums
     * is minimum
     * 6) Count number of ways to partition a set into k subsets
     * 7) Count all subsequences having product less than K
     * 8) Count of subsequences of length n having palindromic first and last
     * characters
     * 
     */

    private int minimumDeletion(int[] arr) {
        return arr.length - lengthOfLIS(arr);
    }

    private int maxIncreasingSum(int[] arr) {
        int n = arr.length;
        // dp[i] : max sum of increasing subsequence ending at index i
        int[] dp = new int[n];
        int max = arr[0];
        for (int i = 0; i < n; i++) {
            dp[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], arr[i] + dp[j]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    private void helper(int[] arr, int[] tail, int n) {
        for (int i = 0; i < n; i++) {
            tail[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    tail[i] = Math.max(tail[j] + 1, tail[i]);
                }
            }
        }
    }

    public int longestBitonicSubsequence(int[] arr) {
        // Bitonic Subsequence : a subsequence that is first increasing then decreasing
        // { 1, 11, 2, 10, 4, 5, 2, 1 }
        int n = arr.length;

        int[] lis = new int[n];
        int[] lds = new int[n];

        helper(arr, lis);

        int[] revArr = new int[n];

        for (int i = 0; i < n; i++) {
            revArr[i] = arr[n - i - 1];
        }

        helper(revArr, lds);

        int maxBitonicLen = 0;
        for (int i = 0; i < n; i++) {
            maxBitonicLen = Math.max(maxBitonicLen, lis[i] + lds[n - i - 1] - 1);
        }
        return maxBitonicLen;
    }

    // To do : do above in nlogn time
    private void helper(int arr[], int[] tail) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            tail[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && tail[i] < tail[j] + 1) {
                    tail[i] = tail[j] + 1;
                }
            }
        }
    }

    private int ceilSearch(int arr[], int x) {
        int low = 0;
        int high = arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    // Time complexity : O(n^2)
    public int buildingBridges(int[][] bridges) {
        int n = bridges.length;
        // sort according to first value and if 1st value is same sort according to
        // second value
        Arrays.sort(bridges, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });
        int max = 0;
        // lis of sorted array of 2nd value
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (bridges[i][1] > bridges[j][1]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // Time complexity : O(n^2)
    public int longestChainPairs(int[][] pairs) {
        int n = pairs.length;
        int max = 0;
        int[] lis = new int[n];

        Arrays.sort(pairs, (a, b) -> a[0] - b[0]); // sort according to first value

        // lis of sorted array of 1st value
        for (int i = 0; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < n; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }

            }
            max = Math.max(max, lis[i]);
        }
        return max;
    }

}
