package Memoisation;

import java.util.Arrays;

public class HouseRobber {
    int dp[];

    private int solve(int[] nums, int idx) {
        if (idx == 0)
            return nums[0];
        if (idx < 0)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];
        int max = nums[idx] + solve(nums, idx - 2); // pick
        int skip = solve(nums, idx - 1); // not pick
        return dp[idx] = Math.max(skip, max);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(nums, n - 1);
    }
}
