public class FrogKJump {
    static int k;

    private static int solve(int[] heights, int idx) {
        if (idx == 0)
            return 0;
        int minSteps = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (idx - i >= 0) {
                int jump = Math.abs(heights[idx] - heights[idx - i]) + solve(heights, idx - i);
                minSteps = Math.min(jump, minSteps);
            }
        }
        return minSteps;
    }

    public static int frogJump(int n, int heights[], int k_steps) {
        k = k_steps;
        return solve(heights, n - 1);
    }
}
