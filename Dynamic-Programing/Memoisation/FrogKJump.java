package Memoisation;

import java.util.*;

public class FrogKJump {
    static int[] dp;
    static int k;

    private static int solve(int[] heights, int idx) {
        if (idx == 0)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];
        int minSteps = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (idx - i >= 0) {
                int jump = Math.abs(heights[idx] - heights[idx - i]) + solve(heights, idx - i);
                minSteps = Math.min(jump, minSteps);
            }
        }
        return dp[idx] = minSteps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        k = sc.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }
        dp = new int[n];
        Arrays.fill(dp, -1);
        System.out.println(solve(heights, n - 1));
        sc.close();
    }
}
