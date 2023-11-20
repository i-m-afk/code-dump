//Problem statement : https://leetcode.com/problems/house-robber/description/
public class HouseRobber {
    private int solve(int[] nums, int idx) {
        if (idx == 0)
            return nums[0];
        if (idx < 0)
            return 0;
        int max = nums[idx] + solve(nums, idx - 2); // pick
        int skip = solve(nums, idx - 1); // not pick
        return Math.max(skip, max);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        return solve(nums, n - 1);
    }
}
