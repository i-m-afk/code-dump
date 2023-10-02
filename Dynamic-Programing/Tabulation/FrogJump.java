
public class FrogJump {
    private static int dp[];

    public static int frogJump(int n, int heights[]) {
        dp = new int[n];
        dp[0] = 0;
        // Bottom - Up
        for (int i = 1; i < n; i++) {
            // dp[i] = minimum energy required to reach idx i from idx 0
            int first_step = Math.abs(heights[i - 1] - heights[i]) + dp[i - 1];
            int second_step = Integer.MAX_VALUE;
            if (i > 1) {
                second_step = Math.abs(heights[i - 2] - heights[i]) + dp[i - 2];
            }
            dp[i] = Math.min(first_step, second_step);
        }
        return dp[n - 1];
    }

    // space optimized
    public static int frogJump2(int n, int heights[]) {
        int prev1 = 0, prev2 = 0;
        for (int i = 1; i < n; i++) {
            int first_step = Math.abs(heights[i - 1] - heights[i]) + prev1;
            int second_step = Integer.MAX_VALUE;
            if (i > 1) {
                second_step = Math.abs(heights[i - 2] - heights[i]) + prev2;
            }
            int curr = Math.min(first_step, second_step);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

}
